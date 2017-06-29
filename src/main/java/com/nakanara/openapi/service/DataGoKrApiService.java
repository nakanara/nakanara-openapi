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
public class DataGoKrApiService {

    public static final String URL_APT_DEAL = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";   // TODO
    public static final String URL_APT_RANT = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent";    // todo

    protected static final String OPEN_API_SERVICE_KEY = "QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D"; // TODO



    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    static final Logger logger = LoggerFactory.getLogger(DataGoKrApiService.class);

    /**
     * Date.go.kr 수집 초기 설정
     * @param domain
     * @param params
     */
    public String dataGoKrInit(String domain, Map<String, String> params) {

        Iterator<String> it = params.keySet().iterator();
        StringBuffer buf = new StringBuffer();

        while(it.hasNext()) {
            String k = it.next();
            String v = params.get(k);

            if(buf.length() > 0) buf.append("&");

            buf.append(k).append("=").append(v);
        }

        logger.info("domain: {}, params: {}", domain, buf.toString());

        domain = domain + "?" + buf.toString();

        return domain;

    }


    /**
     * 데이터 수집.
     * @return
     */
    public String collection(String collectinUrl) {
        //perSetting();

        StringBuffer buf = new StringBuffer();
        BufferedReader in = null;

        if(StringUtil.isEmpty(collectinUrl)) {
            logger.error("Domain is Empty = {}", collectinUrl);
            return "{}";
        }

        try {

            String http_url = collectinUrl;

            logger.debug("collection Start Domain={}", collectinUrl);

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
