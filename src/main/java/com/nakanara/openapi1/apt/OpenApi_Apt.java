package com.nakanara.openapi1.apt;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nakanara.openapi1.DataGoKr;
import com.nakanara.openapi1.apt.dao.RTMSDao;
import com.nakanara.openapi1.apt.dao.TcCodeDao;
import com.nakanara.util.DataKrUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by steg on 2017-06-22.
 */
public class OpenApi_Apt extends DataGoKr{


    Logger logger = LoggerFactory.getLogger(OpenApi_Apt.class);
    public OpenApi_Apt() {

        getLocationCode();
    }

    public void OpenApi_Apt_1(){


//        dataGoKrInit("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?" +
//                "serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D" +
//                "&pageNo=1&startPage=1&numOfRows=10&pageSize=10&LAWD_CD=11110&DEAL_YMD=201706&_type=json");

        int totalPage = 0;
        int curPage = 1;
        String local_code = "11305";
        String search_yymm = "201706";


        getLocationCode();
        if(true) return;

        do {

            Map<String, String> params = new HashMap<String, String>();
            params.put("serviceKey", "QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D");
            params.put("pageNo", "" + curPage);
            //params.put("startPage", "1");
            params.put("numOfRows", "1000");
            params.put("pageSize", "1000");
            params.put("LAWD_CD", local_code);
            params.put("DEAL_YMD", "201706");
            params.put("_type", "json");

            dataGoKrInit("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev", params);


            //String jsonData = collection();
            String jsonData = "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL SERVICE.\"},\"body\":{\"items\":{\"item\":[{\"거래금액\":\"    52,000\",\"건축년도\":2010,\"년\":2017,\"도로명\":\"삼양로27길\",\"도로명건물본번호코드\":\"00019\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":4124230,\"법정동\":\"미아동\",\"법정동본번코드\":\"0812\",\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10100,\"법정동지번코드\":1,\"아파트\":\"삼성래미안트리베라2단지\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-4129\",\"전용면적\":84.29,\"지번\":812,\"지역코드\":11305,\"층\":10},{\"거래금액\":\"    35,000\",\"건축년도\":2004,\"년\":2017,\"도로명\":\"솔샘로\",\"도로명건물본번호코드\":\"00174\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":3005042,\"법정동\":\"미아동\",\"법정동본번코드\":1353,\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10100,\"법정동지번코드\":1,\"아파트\":\"에스케이북한산시티\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-6\",\"전용면적\":59.98,\"지번\":1353,\"지역코드\":11305,\"층\":7},{\"거래금액\":\"    37,800\",\"건축년도\":2004,\"년\":2017,\"도로명\":\"솔샘로\",\"도로명건물본번호코드\":\"00174\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":3005042,\"법정동\":\"미아동\",\"법정동본번코드\":1353,\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10100,\"법정동지번코드\":1,\"아파트\":\"에스케이북한산시티\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-6\",\"전용면적\":84.71,\"지번\":1353,\"지역코드\":11305,\"층\":14},{\"거래금액\":\"    31,000\",\"건축년도\":1996,\"년\":2017,\"도로명\":\"도봉로\",\"도로명건물본번호코드\":\"00157\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":3005039,\"법정동\":\"미아동\",\"법정동본번코드\":1351,\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10100,\"법정동지번코드\":1,\"아파트\":\"두원프라자\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-3\",\"전용면적\":84.24,\"지번\":1351,\"지역코드\":11305,\"층\":4},{\"거래금액\":\"    37,800\",\"건축년도\":2004,\"년\":2017,\"도로명\":\"솔샘로\",\"도로명건물본번호코드\":\"00159\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":3005042,\"법정동\":\"미아동\",\"법정동본번코드\":1354,\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10100,\"법정동지번코드\":1,\"아파트\":\"벽산라이브파크\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-13\",\"전용면적\":84.89,\"지번\":1354,\"지역코드\":11305,\"층\":6},{\"거래금액\":\"    38,000\",\"건축년도\":2004,\"년\":2017,\"도로명\":\"솔샘로\",\"도로명건물본번호코드\":\"00159\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":3005042,\"법정동\":\"미아동\",\"법정동본번코드\":1354,\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10100,\"법정동지번코드\":1,\"아파트\":\"벽산라이브파크\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-13\",\"전용면적\":84.89,\"지번\":1354,\"지역코드\":11305,\"층\":23},{\"거래금액\":\"    20,000\",\"건축년도\":1990,\"년\":2017,\"도로명\":\"오패산로60길\",\"도로명건물본번호코드\":\"00021\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":4124419,\"법정동\":\"미아동\",\"법정동본번코드\":\"0258\",\"법정동부번코드\":\"0732\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10100,\"법정동지번코드\":1,\"아파트\":\"한일\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-8\",\"전용면적\":54.99,\"지번\":\"258-732\",\"지역코드\":11305,\"층\":4},{\"거래금액\":\"    44,300\",\"건축년도\":2002,\"년\":2017,\"도로명\":\"월계로21가길\",\"도로명건물본번호코드\":\"00041\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":4124458,\"법정동\":\"미아동\",\"법정동본번코드\":1355,\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10100,\"법정동지번코드\":1,\"아파트\":\"미아한일유앤아이\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-14\",\"전용면적\":129.78,\"지번\":1355,\"지역코드\":11305,\"층\":1},{\"거래금액\":\"    47,200\",\"건축년도\":2011,\"년\":2017,\"도로명\":\"삼양로27길\",\"도로명건물본번호코드\":\"00095\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":4124230,\"법정동\":\"미아동\",\"법정동본번코드\":\"0811\",\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10100,\"법정동지번코드\":1,\"아파트\":\"두산위브트레지움\",\"월\":6,\"일\":\"11~20\",\"일련번호\":\"11305-4255\",\"전용면적\":84.99,\"지번\":811,\"지역코드\":11305,\"층\":19},{\"거래금액\":\"    46,000\",\"건축년도\":2004,\"년\":2017,\"도로명\":\"솔샘로\",\"도로명건물본번호코드\":\"00174\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":3005042,\"법정동\":\"미아동\",\"법정동본번코드\":1353,\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10100,\"법정동지번코드\":1,\"아파트\":\"에스케이북한산시티\",\"월\":6,\"일\":\"11~20\",\"일련번호\":\"11305-6\",\"전용면적\":114.85,\"지번\":1353,\"지역코드\":11305,\"층\":12},{\"거래금액\":\"    27,000\",\"건축년도\":1991,\"년\":2017,\"도로명\":\"한천로105길\",\"도로명건물본번호코드\":\"00023\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":4124549,\"법정동\":\"번동\",\"법정동본번코드\":\"0242\",\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10200,\"법정동지번코드\":1,\"아파트\":\"주공1단지\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-24\",\"전용면적\":49.94,\"지번\":242,\"지역코드\":11305,\"층\":4},{\"거래금액\":\"    31,300\",\"건축년도\":1998,\"년\":2017,\"도로명\":\"오현로\",\"도로명건물본번호코드\":\"00128\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"02\",\"도로명지상지하코드\":0,\"도로명코드\":3108004,\"법정동\":\"번동\",\"법정동본번코드\":\"0657\",\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10200,\"법정동지번코드\":1,\"아파트\":\"동문\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-17\",\"전용면적\":59.64,\"지번\":657,\"지역코드\":11305,\"층\":14},{\"거래금액\":\"    28,500\",\"건축년도\":1999,\"년\":2017,\"도로명\":\"한천로109길\",\"도로명건물본번호코드\":\"00083\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":4124551,\"법정동\":\"번동\",\"법정동본번코드\":\"0136\",\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10200,\"법정동지번코드\":1,\"아파트\":\"번동솔그린\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-21\",\"전용면적\":59.82,\"지번\":136,\"지역코드\":11305,\"층\":8},{\"거래금액\":\"    30,600\",\"건축년도\":2003,\"년\":2017,\"도로명\":\"오현로\",\"도로명건물본번호코드\":\"00156\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"02\",\"도로명지상지하코드\":0,\"도로명코드\":3108004,\"법정동\":\"번동\",\"법정동본번코드\":\"0139\",\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10200,\"법정동지번코드\":1,\"아파트\":\"한진그랑빌(해모로)\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-28\",\"전용면적\":59.94,\"지번\":139,\"지역코드\":11305,\"층\":11},{\"거래금액\":\"    44,800\",\"건축년도\":2009,\"년\":2017,\"도로명\":\"덕릉로41길\",\"도로명건물본번호코드\":\"00012\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":4124047,\"법정동\":\"번동\",\"법정동본번코드\":\"0410\",\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10200,\"법정동지번코드\":1,\"아파트\":\"수유역두산위브1\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-4064\",\"전용면적\":84.99,\"지번\":410,\"지역코드\":11305,\"층\":19},{\"거래금액\":\"    35,700\",\"건축년도\":2005,\"년\":2017,\"도로명\":\"도봉로\",\"도로명건물본번호코드\":\"00352\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"02\",\"도로명지상지하코드\":0,\"도로명코드\":3005039,\"법정동\":\"번동\",\"법정동본번코드\":\"0418\",\"법정동부번코드\":\"0003\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10200,\"법정동지번코드\":1,\"아파트\":\"효성인텔리안\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-161\",\"전용면적\":81.12,\"지번\":\"418-3\",\"지역코드\":11305,\"층\":8},{\"거래금액\":\"    28,400\",\"건축년도\":2001,\"년\":2017,\"도로명\":\"오현로\",\"도로명건물본번호코드\":\"00132\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"02\",\"도로명지상지하코드\":0,\"도로명코드\":3108004,\"법정동\":\"번동\",\"법정동본번코드\":\"0148\",\"법정동부번코드\":\"0503\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10200,\"법정동지번코드\":1,\"아파트\":\"장원(503)\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-64\",\"전용면적\":76.35,\"지번\":\"148-503\",\"지역코드\":11305,\"층\":3},{\"거래금액\":\"    19,000\",\"건축년도\":1991,\"년\":2017,\"도로명\":\"오현로\",\"도로명건물본번호코드\":\"00207\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"02\",\"도로명지상지하코드\":0,\"도로명코드\":3108004,\"법정동\":\"번동\",\"법정동본번코드\":\"0234\",\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10200,\"법정동지번코드\":1,\"아파트\":\"주공4단지\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-25\",\"전용면적\":41.3,\"지번\":234,\"지역코드\":11305,\"층\":4},{\"거래금액\":\"    28,000\",\"건축년도\":1999,\"년\":2017,\"도로명\":\"한천로109길\",\"도로명건물본번호코드\":\"00083\",\"도로명건물부번호코드\":\"00000\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":4124551,\"법정동\":\"번동\",\"법정동본번코드\":\"0136\",\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10200,\"법정동지번코드\":1,\"아파트\":\"번동솔그린\",\"월\":6,\"일\":\"11~20\",\"일련번호\":\"11305-21\",\"전용면적\":59.82,\"지번\":136,\"지역코드\":11305,\"층\":14},{\"거래금액\":\"    29,400\",\"건축년도\":1993,\"년\":2017,\"도로명\":\"삼각산로\",\"도로명건물본번호코드\":\"00143\",\"도로명건물부번호코드\":\"00001\",\"도로명시군구코드\":11305,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":3108001,\"법정동\":\"수유동\",\"법정동본번코드\":\"0205\",\"법정동부번코드\":\"0000\",\"법정동시군구코드\":11305,\"법정동읍면동코드\":10300,\"법정동지번코드\":1,\"아파트\":\"수유벽산1차\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"11305-33\",\"전용면적\":63.78,\"지번\":205,\"지역코드\":11305,\"층\":6}]},\"numOfRows\":1000,\"pageNo\":1,\"totalCount\":20}}}";

            logger.info("raw data ={}", jsonData);

            Gson gson = new Gson();
            Map<String, Object> jsonObject = gson.fromJson(jsonData, new TypeToken<Map<String, Object>>(){}.getType());

            //logger.info("size = {} Data = {}", jsonObject.size(), jsonObject);

            Map<String, Object> response = (Map) jsonObject.get("response");

            //logger.info("response size = {} Data = {}", response.size(), response);

            Map<String, Object> body = (Map) response.get("body");
            totalPage = (int) DataKrUtil.getDataKrDouble(body.get("totalCount"));

            //logger.info("body items = {} Data = {}", body.size(), body);

            Map<String, Object> items = (Map) body.get("items");

            //logger.info("items items = {} Data = {}", items.size(), items);

            List<Map<String, Object>> item = (List) items.get("item");

            //logger.info("item items = {} Data = {}", item.size(), item);

            List<RTMSDao> list = new ArrayList<RTMSDao>();
            for ( Map<String, Object> m : item) {

                //logger.info("item 거래 금액: {} 건축년도: {} //{}", m.get("거래금액"), m.get("건축년도"), m);
                logger.info("raw:{}", m);
                RTMSDao rtmsDao = new RTMSDao(m);
                list.add(rtmsDao);
            }

            addRTMS(list);

            ++curPage;

            logger.info("curPage {} / totalPage: {} ", curPage, totalPage);
        } while(totalPage > curPage);

    }

    public void getLocationCode() {

        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Session session = factory.openSession();

        //Query query = session.createQuery("select code_id, code_name from tc_code where code_type = ?");
        //query.setParameter(0, "LAWD");

        //List<Map<String,String>> list = query.list();

        List<TcCodeDao> list = session.createCriteria(TcCodeDao.class).list();
        logger.info("Size {}", list.size());
        for(TcCodeDao tcCodeDao : list) {
            logger.info("m: {}", tcCodeDao);
        }
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++/// END");
    }


    public void addRTMS(List<RTMSDao> rtmsDaos) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            for(RTMSDao rtmsDao : rtmsDaos) {
                session.save(rtmsDao);
            }
            tx.commit();
        } catch(HibernateException e){
            if(tx != null) tx.commit();
            logger.error("addRTMS {}", e);
        }finally {
            session.close();
        }

    }

    public static void main(String args[]) {
        OpenApi_Apt openApi_apt = new OpenApi_Apt();
    }
}
