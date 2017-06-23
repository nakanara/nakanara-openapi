package com.nakanara.openapi1;

import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by steg on 2017-06-14.
 */
public class OpenApi1 {


    public void openURI(){

    }

    public static void print_content(HttpURLConnection con){
        if(con!=null){

            try {

                System.out.println("****** Content of the URL ********");
                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(con.getInputStream(), "utf-8"));

                String input;

                while ((input = br.readLine()) != null){
                    System.out.println(input);
                }
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String args[]){

        String domain = "http://openapi.ccourt.go.kr/openapi/services/PrecedentInfoSvc/getOcprPrcdntInfo";
        //String serviceKey = "serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D";
        String serviceKey = "serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D&&searchValue=%E3%85%81";
        String serviceId = "";
//http://openapi.ccourt.go.kr/openapi/services/IncidentInfoSvc/getIncdntBasisInfo?serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D&eventNm=%EA%B5%AD%EC%84%A0%EB%8C%80%EB%A6%AC%EC%9D%B8%EC%84%A0%EC%9E%84&inqDate=20130621
//http://openapi.ccourt.go.kr/openapi/services/PrecedentInfoSvc/getOcprPrcdntInfo?serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D&searchValue=%E3%85%81
//http://openapi.ccourt.go.kr/openapi/services/PrecedentInfoSvc/getOcprPrcdntInfo?serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D
//http://kosis.kr/services/IncidentInfoSvc/getIncdntBasisInfo?serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D&eventNm=%EA%B5%AD%EC%84%A0%EB%8C%80%EB%A6%AC%EC%9D%B8%EC%84%A0%EC%9E%84&inqDate=20130621
        try {

            String https_url = domain + serviceId + "?" + serviceKey;

            // 프록시 설정
            System.setProperty("http.proxyHost", "172.30.4.18") ;
            System.setProperty("http.proxyPort", "8080");


            System.out.println(https_url);
            URL url = new URL(https_url);
            URLConnection con = url.openConnection();

            //dumpl all cert info
            //print_https_cert(con);

            //dump all the content
            //OpenApi1.print_content(con);

            con.setRequestProperty("CONTENT-TYPE","text/html");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
            String inputLine;
            String buffer = "";
            while ((inputLine = in.readLine()) != null){
                buffer += inputLine.trim();
            }
            System.out.println("buffer : " + buffer);
            in.close();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
