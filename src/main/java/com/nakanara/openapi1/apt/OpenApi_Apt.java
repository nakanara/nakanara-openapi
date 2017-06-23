package com.nakanara.openapi1.apt;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nakanara.openapi1.DataGoKr;
import com.nakanara.openapi1.apt.dao.RTMSDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by steg on 2017-06-22.
 */
public class OpenApi_Apt extends DataGoKr{

    Logger logger = LoggerFactory.getLogger(OpenApi_Apt.class);

    public OpenApi_Apt(){

        //dataGoKrInit("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?_wadl&_type=xml&DEAL_YMD=201706&LAWD_CD=11110&pageNo=1&numOfRows=10&startPage=1&pageSize=10", "QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D");
        dataGoKrInit("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D" +
                "&pageNo=1&startPage=1&numOfRows=10&pageSize=10&LAWD_CD=11110&DEAL_YMD=201706&_type=json");
        String jsonData = collection();
        //http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D&pageNo=1&startPage=1&numOfRows=10&pageSize=10&LAWD_CD=11110&DEAL_YMD=201706

        Gson gson = new Gson();
        Map<String, Object> jsonObject = gson.fromJson(jsonData, new TypeToken<Map<String, Object>>(){}.getType());

        logger.info("size = {} Data = {}", jsonObject.size(), jsonObject);

        Map<String, Object> response = (Map) jsonObject.get("response");

        logger.info("response size = {} Data = {}", response.size(), response);

        Map<String, Object> body = (Map) response.get("body");

        logger.info("body items = {} Data = {}", body.size(), body);

        Map<String, Object> items = (Map) body.get("items");

        logger.info("items items = {} Data = {}", items.size(), items);

        List<Map<String, Object>> item = (List) items.get("item");

        logger.info("item items = {} Data = {}", item.size(), item);

        List<RTMSDao> list = new ArrayList<RTMSDao>();
        for ( Map<String, Object> m : item) {

            logger.info("item 거래 금액: {} 건축년도: {} //{}", m.get("거래금액"), m.get("건축년도"), m);
            RTMSDao rtmsDao = new RTMSDao(m);
            logger.info(rtmsDao.toString());
            list.add(rtmsDao);

        }
    }

    public static void main(String args[]) {
        OpenApi_Apt openApi_apt = new OpenApi_Apt();
    }
}
