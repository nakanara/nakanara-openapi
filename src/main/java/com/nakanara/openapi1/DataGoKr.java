package com.nakanara.openapi1;

import com.nakanara.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by steg on 2017-06-22.
 */
public class DataGoKr {

    private String domain = "";
    private String serviceKey="";

    static final Logger logger = LoggerFactory.getLogger(DataGoKr.class);


    public DataGoKr(){

    }
    public void dataGoKrInit(String domain) {
        this.domain = domain;
    }
    public void dataGoKrInit(String domain, String serviceKey) {
        this.domain = domain;
        this.serviceKey = serviceKey;
    }

    public String collection() {
        perSetting();

        StringBuffer buf = new StringBuffer();
        /*if(StringUtil.isEmpty(domain)) {
            logger.error("Domain is Empty = {}", domain);
            return;
        }
        */
        try {

            String http_url = "";
            if(StringUtil.isEmpty(serviceKey)) {
                http_url = this.domain;
            } else {
                http_url = this.domain + "?serviceKey=" + serviceKey;
            }


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

    public void xmlParsing(String str) {
        //DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //Document document = documentBuilder.parse(str);
    }

    public void perSetting(){
        // 프록시 설정
        System.setProperty("http.proxyHost", "172.30.4.18") ;
        System.setProperty("http.proxyPort", "8080");
    }

    public static void main(String args[]) {
        new DataGoKr();
    }
}
