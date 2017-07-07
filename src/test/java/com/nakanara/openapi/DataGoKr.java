package com.nakanara.openapi;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by steg on 2017-06-22.
 */
public class DataGoKr {

    protected static SessionFactory factory;
    private String domain = "";

    static final Logger logger = LoggerFactory.getLogger(DataGoKr.class);


    /*public DataGoKr(){
        try{
            logger.info("INIT DataGoKr");
            factory = new Configuration().configure("/conf/hibernate-config.xml")
                    .buildSessionFactory();
        }catch(Exception e) {
            logger.error("Failed to create sessionFactory object. {}", e);
        }
    }*/

    public void dataGoKrInit(String domain) {
        this.domain = domain;
    }

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


    public String collection() {
//        perSetting();

        StringBuffer buf = new StringBuffer();
        /*if(StringUtil.isEmpty(domain)) {
            logger.error("Domain is Empty = {}", domain);
            return;
        }
        */
        try {

            String http_url = this.domain;


            logger.info("collection Start Domain={} url={}", domain, http_url);

            URL url = new URL(http_url);
            URLConnection con = url.openConnection();

            con.setRequestProperty("CONTENT-TYPE","text/html");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
            String inputLine;

            while ((inputLine = in.readLine()) != null){
                buf.append(inputLine.trim());
            }
            //System.out.println("buffer : " + buf.toString());
            logger.info("buffer : {}", buf.toString());

            //xmlParsing(buffer);
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();

    }

    public void perSetting(){
        // 프록시 설정
        System.setProperty("http.proxyHost", "172.30.4.18") ;
        System.setProperty("http.proxyPort", "8080");
    }



    @org.junit.Test
    public void test(){

        String names[] = {"a","b"};
        String names2[] = {"a","b"};
        Assert.assertArrayEquals(names2, names);

        List someList = new ArrayList();
        Assert.assertNotNull("조회결과 null", someList);
        Assert.assertTrue(someList.size() > 0);
        Assert.assertEquals(3, someList.size());
    }



    public static void main(String args[]) {
        new DataGoKr();
    }
}
