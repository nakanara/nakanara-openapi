package com.nakanara.openapi.apt;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nakanara.openapi.DataGoKr;
import com.nakanara.openapi.apt.dao.TbRtmsDao;
import com.nakanara.openapi.apt.dao.TcCodeDao;
import com.nakanara.util.DataKrUtil;
import com.nakanara.util.StopWatchUtil;
import com.nakanara.util.StringUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 아파트 매매 이력.
 * Created by steg on 2017-06-22.
 */
public class OpenApi_Apt extends DataGoKr{


    Logger logger = LoggerFactory.getLogger(OpenApi_Apt.class);
    public OpenApi_Apt() {
        //this("");
        delRTMSYYMM("201706");
    }

    public OpenApi_Apt(String yymm) {
        Calendar startCal = StopWatchUtil.start(OpenApi_Apt.class.toString());
        List<TcCodeDao> tcCodeDaos = getLocationCode();
        int totalRow = 0;
        int subRow = 0;
        int nCnt =0;

        if(StringUtil.isEmpty(yymm)) {
            yymm = "" + Calendar.getInstance().get(Calendar.YEAR);
        }

        delRTMSYYMM(yymm);

        for(TcCodeDao tcCodeDao : tcCodeDaos) {
            logger.info("Start YYMM: {} Location: {}", yymm, tcCodeDao.getCode_name());
            subRow = getRowData(yymm, tcCodeDao.getCode_id());
            totalRow += subRow;
            logger.info("Location: {} / {} Row: {} / {}", tcCodeDao.getCode_id(), tcCodeDao.getCode_name(), subRow, totalRow);
        }

        StopWatchUtil.stop(OpenApi_Apt.class.toString(), startCal);
    }

    public OpenApi_Apt(String yymm, String localCode) {
        getRowData(yymm, localCode);
    }

    public int getRowData(String yymm, String local_code){

//        dataGoKrInit("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?" +
//                "serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D" +
//                "&pageNo=1&startPage=1&numOfRows=10&pageSize=10&LAWD_CD=11110&DEAL_YMD=201706&_type=json");

        int totalCount = 0;
        int curRow =0;
        int totalPage = 0;
        int curPage = 1;
        int totalRow = 0;
        String search_yymm = yymm;

        do {

            Map<String, String> params = new HashMap<String, String>();
            params.put("serviceKey", "QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D");
            params.put("pageNo", "" + curPage);
            //params.put("startPage", "1");
            params.put("numOfRows", "1000");
            params.put("pageSize", "1000");
            params.put("LAWD_CD", local_code);
            params.put("DEAL_YMD", search_yymm);
            params.put("_type", "json");

            dataGoKrInit("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev", params);

            String jsonData = collection();

            //String jsonData = "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL SERVICE.\"},\"body\":{\"items\":{\"item\":{\"거래금액\":\"     9,800\",\"건축년도\":2006,\"년\":2017,\"도로명\":\"진장로\",\"도로명건물본번호코드\":\"00051\",\"도로명건물부번호코드\":\"00016\",\"도로명시군구코드\":45720,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":3274046,\"법정동\":\"진안읍 군상리\",\"법정동본번코드\":\"0200\",\"법정동부번코드\":\"0001\",\"법정동시군구코드\":45720,\"법정동읍면동코드\":25021,\"법정동지번코드\":1,\"아파트\":\"진안군상고향마을\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"45720-10\",\"전용면적\":59.81,\"지번\":\"200-1\",\"지역코드\":45720,\"층\":10}},\"numOfRows\":1000,\"pageNo\":1,\"totalCount\":1}}}";

            logger.info("raw data ={}", jsonData);

            Gson gson = new Gson();
            Map<String, Object> jsonObject = gson.fromJson(jsonData, new TypeToken<Map<String, Object>>(){}.getType());

            //logger.info("size = {} Data = {}", jsonObject.size(), jsonObject);

            Map<String, Object> response = (Map) jsonObject.get("response");

            //logger.info("response size = {} Data = {}", response.size(), response);

            Map<String, Object> body = (Map) response.get("body");
            totalCount = (int) DataKrUtil.getDataKrDouble(body.get("totalCount"));

            if(totalCount == 0) return totalRow;

            //logger.info("body items = {} Data = {}", body.size(), body);

            Map<String, Object> items = (Map) body.get("items");

            //logger.info("items items = {} Data = {}", items.size(), items);

            List<Map<String, Object>> item = null;
            if(totalCount == 1) {
                item = new ArrayList<Map<String, Object>>();
                item.add((Map<String, Object>)items.get("item"));
            } else {
                item = (List) items.get("item");
            }


            //logger.info("item items = {} Data = {}", item.size(), item);

            List<TbRtmsDao> list = new ArrayList<TbRtmsDao>();
            for ( Map<String, Object> m : item) {

                //logger.info("item 거래 금액: {} 건축년도: {} //{}", m.get("거래금액"), m.get("건축년도"), m);
                //logger.info("raw:{}", m);
                TbRtmsDao rtmsDao = new TbRtmsDao(m);
                list.add(rtmsDao);
                totalRow++;
                ++curRow;
            }

            addRTMS(list);
            curPage++;

            logger.info("curRow {} / totalPage: {} / curPage: {}", curRow, totalCount, curPage);
        } while(totalCount > curRow);

        return totalRow;

    }

    /**
     * 지역 코드 조회
     * @return
     */
    public List<TcCodeDao> getLocationCode() {

        Session session = factory.getCurrentSession();

        Query query = session.createQuery("from TcCodeDao where code_type = ?");
        query.setParameter(0, "LAWD");
        List<TcCodeDao> list = query.list();

        return list;

    }


    public void addRTMS(List<TbRtmsDao> rtmsDaos) {
        Session session = factory.getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            for(TbRtmsDao rtmsDao : rtmsDaos) {
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

    public void delRTMSYYMM(String yymm) {
        logger.info("Delete TbRTMS YYMM: {}", yymm);
        Session session = factory.getCurrentSession();
        Transaction tx = null;

        Query query = session.createQuery("delete TbRTMSDao where rtmsDealYY = :rtmsDealYY and rtmsDealMM = :rtmsDealMM");
        query.setParameter("rtmsDealYY", Integer.parseInt(yymm.substring(0,4)));
        query.setParameter("rtmsDealMM",Integer.parseInt(yymm.substring(4,6)));

        logger.info("llll {}", query.toString());

        try {
            tx = session.beginTransaction();
            query.executeUpdate();
            tx.commit();
        } catch(HibernateException e){
            if(tx != null) tx.commit();
            logger.error("delRTMSYYMM {}", e);
        }finally {
            session.close();
        }
    }

    public static void main(String args[]) {
        OpenApi_Apt openApi_apt = new OpenApi_Apt();
    }
}
