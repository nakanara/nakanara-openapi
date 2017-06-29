package com.nakanara.openapi.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nakanara.openapi.apt.dao.RTMSDao;
import com.nakanara.openapi.apt.dao.TcCodeDao;
import com.nakanara.util.DataKrUtil;
import com.nakanara.util.DateUtil;
import com.nakanara.util.StopWatchUtil;
import com.nakanara.util.StringUtil;
import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by steg on 2017-06-27.
 */
@Service
public class OpenApiAptService extends DataGoKrApiService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory = null;

    private Logger logger = LoggerFactory.getLogger(OpenApiAptService.class);


    /**
     * 지역 코드 조회
     * @return
     */
    public List<TcCodeDao> getLocationCode() {

        //List<TcCodeDao> list = (List<TcCodeDao>)getHibernateTemplate().find("from TcCodeDao where code_type = ?", "LAWD");

        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from TcCodeDao where code_type = ?");
        query.setParameter(0, "LAWD");
        List<TcCodeDao> list = query.list();

        return list;
    }

    /**
     * 아파트 구매 내역.
     */
    @Transactional(readOnly = false)
    public void startOpenApi_AptDeal() {
        startOpenApi_AptDeal(URL_APT_DEAL, DateUtil.getYYMM());

        /*        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            //this("");
            delRTMSYYMM(DateUtil.getYYMM());
            //startOpenApi_Apt(DateUtil.getYYMM());

            tx.commit();
        } catch(HibernateException e){
            if(tx != null) tx.commit();
            logger.error("addRTMS {}", e);
        }finally {
            session.close();
        }*/
    }

    /**
     * 아파트 구매 내역 api 호출
     * @param yymm 대상 년월 YYYYMM
     */
    public void startOpenApi_AptDeal(String domain, String yymm) {
        Calendar startCal = StopWatchUtil.start(OpenApiAptService.class.toString());
        List<TcCodeDao> tcCodeDaos = getLocationCode();
        int totalRow = 0;
        int subRow = 0;
        int nCnt =0;

        if(StringUtil.isEmpty(yymm)) {
            yymm = "" + Calendar.getInstance().get(Calendar.YEAR);
        }

        delRTMSYYMM(yymm, RTMSDao.RTMS_DEAL);

        for(TcCodeDao tcCodeDao : tcCodeDaos) {
            logger.info("Start YYMM: {} Location: {}", yymm, tcCodeDao.getCode_name());
            subRow = getRowData(domain, yymm, tcCodeDao.getCode_id());
            totalRow += subRow;
            logger.info("Location: {} / {} Row: {} / {}", tcCodeDao.getCode_id(), tcCodeDao.getCode_name(), subRow, totalRow);
        }

        StopWatchUtil.stop(OpenApiAptService.class.toString(), startCal);
    }

    /**
     * 아파트 전세/월세
     */
    @Transactional(readOnly = false)
    public void startOpenApi_AptRant() {

        startOpenApi_AptRant(URL_APT_RANT, DateUtil.getYYMM());


        /*        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            //this("");
            delRTMSYYMM(DateUtil.getYYMM());
            //startOpenApi_Apt(DateUtil.getYYMM());

            tx.commit();
        } catch(HibernateException e){
            if(tx != null) tx.commit();
            logger.error("addRTMS {}", e);
        }finally {
            session.close();
        }*/
    }

    public void startOpenApi_AptRant(String domain, String yymm) {
        Calendar startCal = StopWatchUtil.start(OpenApiAptService.class.toString());
        List<TcCodeDao> tcCodeDaos = getLocationCode();
        int totalRow = 0;
        int subRow = 0;
        int nCnt =0;

        if(StringUtil.isEmpty(yymm)) {
            yymm = "" + Calendar.getInstance().get(Calendar.YEAR);
        }

        delRTMSYYMM(yymm, RTMSDao.RTMS_RANT);

        for(TcCodeDao tcCodeDao : tcCodeDaos) {
            logger.info("Start YYMM: {} Location: {}", yymm, tcCodeDao.getCode_name());
            subRow = getRowData(domain, yymm, tcCodeDao.getCode_id());
            totalRow += subRow;
            logger.info("Location: {} / {} Row: {} / {}", tcCodeDao.getCode_id(), tcCodeDao.getCode_name(), subRow, totalRow);
        }

        StopWatchUtil.stop(OpenApiAptService.class.toString(), startCal);
    }

    /**
     * 데이터 수집.
     * @param domain
     * @param yymm
     * @param local_code
     * @return
     */
    public int getRowData(String domain, String yymm, String local_code){

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

            Map<String, String> params = new HashMap<>();
            params.put("serviceKey", OPEN_API_SERVICE_KEY);
            params.put("pageNo", "" + curPage);
            //params.put("startPage", "1");
            params.put("numOfRows", "1000");
            params.put("pageSize", "1000");
            params.put("LAWD_CD", local_code);
            params.put("DEAL_YMD", search_yymm);
            params.put("_type", "json");

            String url = dataGoKrInit(domain, params);
            String jsonData = collection(url);

            //String jsonData = "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL SERVICE.\"},\"body\":{\"items\":{\"item\":{\"거래금액\":\"     9,800\",\"건축년도\":2006,\"년\":2017,\"도로명\":\"진장로\",\"도로명건물본번호코드\":\"00051\",\"도로명건물부번호코드\":\"00016\",\"도로명시군구코드\":45720,\"도로명일련번호코드\":\"01\",\"도로명지상지하코드\":0,\"도로명코드\":3274046,\"법정동\":\"진안읍 군상리\",\"법정동본번코드\":\"0200\",\"법정동부번코드\":\"0001\",\"법정동시군구코드\":45720,\"법정동읍면동코드\":25021,\"법정동지번코드\":1,\"아파트\":\"진안군상고향마을\",\"월\":6,\"일\":\"1~10\",\"일련번호\":\"45720-10\",\"전용면적\":59.81,\"지번\":\"200-1\",\"지역코드\":45720,\"층\":10}},\"numOfRows\":1000,\"pageNo\":1,\"totalCount\":1}}}";

            logger.info("raw data ={}", jsonData);

            Gson gson = new Gson();
            Map<String, Object> jsonObject = gson.fromJson(jsonData, new TypeToken<Map<String, Object>>(){}.getType());

            Map<String, Object> response = (Map) jsonObject.get("response");

            Map<String, Object> body = (Map) response.get("body");
            totalCount = (int) DataKrUtil.getDataKrDouble(body.get("totalCount"));

            if(totalCount == 0) return totalRow;

            Map<String, Object> items = (Map) body.get("items");

            List<Map<String, Object>> item = null;
            if(totalCount == 1) {
                item = new ArrayList<Map<String, Object>>();
                item.add((Map<String, Object>)items.get("item"));
            } else {
                item = (List) items.get("item");
            }

            List<RTMSDao> list = new ArrayList<>();
            for ( Map<String, Object> m : item) {

                //logger.info("item 거래 금액: {} 건축년도: {} //{}", m.get("거래금액"), m.get("건축년도"), m);
                //logger.info("raw:{}", m);
                RTMSDao rtmsDao = new RTMSDao(m);
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
     * 데이터 추가.
     * @param rtmsDaos
     */
    public void addRTMS(List<RTMSDao> rtmsDaos) {

        Session session = sessionFactory.openSession();

        for(RTMSDao rtmsDao : rtmsDaos) {
            session.save(rtmsDao);
        }

    }

    /**
     * 대상 정보 삭제.
     * @param yymm YYYYMM
     * @param rtmsType 삭제 대상
     */
    public void delRTMSYYMM(String yymm, String rtmsType) {
        logger.info("Delete RTMS YYMM: {}", yymm);

        Session session = sessionFactory.openSession();

        Query query = null;

        if(RTMSDao.RTMS_DEAL.equals(rtmsType)) {
            query = session.createQuery("delete RTMSDao where rtmsDealYY = :rtmsDealYY and rtmsDealMM = :rtmsDealMM and rtmsType = :rtmsType");
            query.setParameter("rtmsDealYY", Integer.parseInt(yymm.substring(0, 4)));
            query.setParameter("rtmsDealMM", Integer.parseInt(yymm.substring(4, 6)));
            query.setParameter("rtmsType", rtmsType);
        } else {
            query = session.createQuery("delete RTMSDao where rtmsDealYY = :rtmsDealYY and rtmsDealMM = :rtmsDealMM and rtmsType not in(:rtmsType)");
            query.setParameter("rtmsDealYY", Integer.parseInt(yymm.substring(0, 4)));
            query.setParameter("rtmsDealMM", Integer.parseInt(yymm.substring(4, 6)));
            query.setParameter("rtmsType", RTMSDao.RTMS_DEAL);
        }

        query.executeUpdate();

    }

}
