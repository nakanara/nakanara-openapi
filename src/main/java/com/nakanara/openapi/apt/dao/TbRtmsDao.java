package com.nakanara.openapi.apt.dao;

import com.nakanara.util.DataKrUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by nakanara on 2017-06-22.
 */
@Entity(name = "TbRtmsDao")
@Data
public class TbRtmsDao implements Serializable{

    public static final String RTMS_DEAL = "APT_TYPE_01";  // 매매
    public static final String RTMS_LEASE  = "APT_TYPE_02";  // 전세
    public static final String RTMS_RANT = "APT_TYPE_03";  // 월세


    @Id
    @Getter @Setter private long rtmsNo; // 일련번호

    @Getter @Setter private int rtmsBullingYY; // 건축년도
    @Getter @Setter private long rtmsDealMoney = 0L; // 거래 금액
    @Getter @Setter private int rtmsDealYY;    // 거래 년
    @Getter @Setter private int rtmsDealMM;   // 거래 월
    @Getter @Setter private String rtmsDealDD;  // 거래 주.
    @Getter @Setter private String rtmsLoadName;    // 도로 명
    @Getter @Setter private String rtmsLoadMainNum; // 도로명건물본번호코드
    @Getter @Setter private String rtmsLoadSubNum;    // 도로명건물부번호코드
    @Getter @Setter private String rtmsLoadNum;   // 도로명일련번호코드
    @Getter @Setter private String rtmsLoadCode;  // 도로명시군구코드
    @Getter @Setter private String rtmsAreaName;    // 법정동
    @Getter @Setter private String rtmsAreaNameCode;    // 법정동본번코드
    @Getter @Setter private String rtmsAreaNameSubCode;    // 법정동부번코드
    @Getter @Setter private String rtmsLocalCode; // 지역코드
    @Getter @Setter private String rtmsName;    // 상호
    @Getter @Setter private String rtmsFloor;     // 층.
    @Getter @Setter private String rtmsSeq; // 일련번호
    @Getter @Setter private double rtmsAreaSize;    // 면적
    @Getter @Setter private String rtmsRaw; // 근본 데이터.

    @Getter @Setter private long rtmsLeaseMoney = 0L; // 보증금.
    @Getter @Setter private long rtmsRantMoney = 0L; // 월세 금액

    @Getter @Setter private String rtmsType = RTMS_DEAL;    // 매매, 전세, 월세 타입.

    public TbRtmsDao() {

    }

    public TbRtmsDao(Map<String, Object> m) {

        //거래금액=   105,000,
        this.rtmsDealMoney = DataKrUtil.getDataKrLong(m.get("거래금액"));
        // 건축년도=2008,
        this.rtmsBullingYY = DataKrUtil.getDataKrInt(m.get("건축년도"));
        // 년=2017.0,
        this.rtmsDealYY = DataKrUtil.getDataKrInt(m.get("년"));
        // 도로명=사직로8길,
        this.rtmsLoadName = DataKrUtil.getDataKrString(m.get("도로명"));
        // 도로명건물본번호코드=00004,
        this.rtmsLoadMainNum = DataKrUtil.getDataKrString(m.get("도로명건물본번호코드"));
        // 도로명건물부번호코드=00000,
        this.rtmsLoadSubNum = DataKrUtil.getDataKrString(m.get("도로명건물부번호코드"));
        // 도로명시군구코드=11110.0,

        // 도로명일련번호코드=03,
        this.rtmsLoadNum = DataKrUtil.getDataKrString(m.get("도로명일련번호코드"));
        // 도로명지상지하코드=0.0,
        // 도로명코드=4100135,
        this.rtmsLoadCode = ""+DataKrUtil.getDataKrString(m.get("도로명코드"));
        // 법정동=사직동,
        this.rtmsAreaName = DataKrUtil.getDataKrString(m.get("법정동"));
        // 법정동본번코드=0009,
        this.rtmsAreaNameCode = DataKrUtil.getDataKrString(m.get("법정동본번코드"));
        // 법정동부번코드=0000,
        this.rtmsAreaNameSubCode = DataKrUtil.getDataKrString(m.get("법정동부번코드"));
        // 법정동시군구코드=11110.0, 법정동읍면동코드=11500.0, 법정동지번코드=1.0,
        // 아파트=광화문풍림스페이스본(9-0),
        this.rtmsName = DataKrUtil.getDataKrString(m.get("아파트"));
        // 월=6.0,
        this.rtmsDealMM = DataKrUtil.getDataKrInt(m.get("월"));
        // 일=11~20,
        this.rtmsDealDD = DataKrUtil.getDataKrString(m.get("일"));
        // 일련번호=11110-2203,
        this.rtmsSeq = DataKrUtil.getDataKrString(m.get("일련번호"));
        // 전용면적=146.92,
        this.rtmsAreaSize = DataKrUtil.getDataKrDouble(m.get("전용면적"));
        // 지번=9.0,
        // 지역코드=11110.0,
        this.rtmsLocalCode = DataKrUtil.getDataKrString(m.get("지역코드"));
        // 층=6.0}
        this.rtmsFloor = DataKrUtil.getDataKrString(m.get("층"));

        /* 전/월세 */
        this.rtmsLeaseMoney = DataKrUtil.getDataKrLong(m.get("보증금액"));
        this.rtmsRantMoney = DataKrUtil.getDataKrLong(m.get("월세금액"));


        if(this.rtmsDealMoney > 0) {
            rtmsType = TbRtmsDao.RTMS_DEAL;
        } else if(this.rtmsLeaseMoney > 0 && this.rtmsRantMoney == 0) {
            rtmsType = TbRtmsDao.RTMS_LEASE;
        } else if(this.rtmsRantMoney > 0) {
            rtmsType = TbRtmsDao.RTMS_RANT;
        }

        this.rtmsRaw = m.toString();
    }

}
