package com.nakanara.openapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nakanara.openapi.apt.dao.RTMSDao;
import com.nakanara.util.DataKrUtil;
import com.nakanara.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by steg on 2017-06-22.
 */
public class Test {

    public static void main(String args[]) {

        String jsonData = "{\"response\":{\"header\":{\"resultCode\":99,\"resultMsg\":\"LIMITED NUMBER OF SERVICE REQUESTS EXCEEDS ERROR.\"}}}";


        Logger logger = LoggerFactory.getLogger("main");


//        Gson gson = new Gson();
//        Map<String, Object> jsonObject = gson.fromJson(jsonData, new TypeToken<Map<String, Object>>(){}.getType());
        Map<String, Object> jsonObject = null;
        try {

            ObjectMapper mapper = new ObjectMapper();
            jsonObject = mapper.readValue(jsonData, HashMap.class);

            logger.info("size = {} Data = {}", jsonObject.size(), jsonObject);

            Map<String, Object> response = (Map) jsonObject.get("response");

            logger.info("response size = {} Data = {}", response.size(), response);

            Map<String, Object> header = (Map) response.get("header");

            logger.info("resultCode ={}, msg={}", header.get("resultCode"), header.get("resultMsg"));

            String resultCode = ""+header.get("resultCode");
            if(!"00".equals(resultCode)) {

                logger.info("Error Code !!!!{}", resultCode);
                return;
            }


            Map<String, Object> body = (Map) response.get("body");

            logger.info("body items = {} totalCount: {}  Data = {}", body.size(), (int)DataKrUtil.getDataKrInt(body.get("totalCount")), body);

            Map<String, Object> items = (Map) body.get("items");

            logger.info("items items = {} Data = {}", items.size(), items);

            List<Map<String, Object>> item = (List) items.get("item");

            logger.info("item items = {} Data = {}", item.size(), item);

            for ( Map<String, Object> m : item) {

                RTMSDao rtmsDao = new RTMSDao(m);
                logger.info("{}", m);
                logger.info("item {}", rtmsDao.toString());

            }

        }catch(IOException ioe) {
            logger.error("Error -{}", ioe);
        }


    }
}
