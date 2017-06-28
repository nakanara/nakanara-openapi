package com.nakanara.openapi.service;

import com.nakanara.util.StringUtil;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by steg on 2017-06-27.
 */
public class DataGoKrApiService extends HibernateDaoSupport {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory = null;

    private String domain = "";

    static final Logger logger = LoggerFactory.getLogger(DataGoKrApiService.class);

    /**
     * Date.go.kr 수집 초기 설정
     * @param domain
     * @param params
     */
    public void dataGoKrInit(String domain, Map<String, String> params) {
        this.domain = domain;

        Iterator<String> it = params.keySet().iterator();
        StringBuffer buf = new StringBuffer();

        while(it.hasNext()) {
            String k = it.next();
            String v = params.get(k);

            if(buf.length() > 0) buf.append("&");

            buf.append(k).append("=").append(v);
        }

        logger.info("domain: {}, params: {}", domain, buf.toString());

        this.domain = domain + "?" + buf.toString();

    }


    /**
     * 데이터 수집.
     * @return
     */
    public String collection() {
        perSetting();

        StringBuffer buf = new StringBuffer();
        BufferedReader in = null;

        if(StringUtil.isEmpty(domain)) {
            logger.error("Domain is Empty = {}", domain);
            return "{}";
        }

        try {

            String http_url = this.domain;

            logger.debug("collection Start Domain={} url={}", domain, http_url);

            URL url = new URL(http_url);
            URLConnection con = url.openConnection();

            con.setRequestProperty("CONTENT-TYPE","text/html");
            in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
            String inputLine;

            while ((inputLine = in.readLine()) != null){
                buf.append(inputLine.trim());
            }

            logger.debug("buffer : {}", buf.toString());

            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                }catch(IOException ioe) {}
            }
        }
        return buf.toString();

    }

    /**
     * 프록시 설정 필요시.
     */
    public void perSetting(){
        // 프록시 설정
        System.setProperty("http.proxyHost", "172.30.4.18") ;
        System.setProperty("http.proxyPort", "8080");
    }
}
