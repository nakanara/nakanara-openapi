package com.nakanara.openapi.apt.dao;

import com.nakanara.util.DataKrUtil;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by steg on 2017-06-22.
 */
@Entity(name = "Rtms")
public class RTMSDao implements Serializable{

    private int rtmsNo; // 일련번호

    private int rtmsBullingYY; // 건축년도
    private long rtmsDealMoney; // 거래 금액
    private int rtmsDealYY;    // 거래 년
    private int rtmsDealMM;   // 거래 월
    private String rtmsDealDD;  // 거래 주.
    private String rtmsLoadName;    // 도로 명
    private String rtmsLoadMainNum; // 도로명건물본번호코드
    private String rtmsLoadSubNum;    // 도로명건물부번호코드
    private String rtmsLoadNum;   // 도로명일련번호코드
    private String rtmsLoadCode;  // 도로명시군구코드
    private String rtmsAreaName;    // 법정동
    private String rtmsAreaNameCode;    // 법정동본번코드
    private String rtmsAreaNameSubCode;    // 법정동부번코드
    private long rtmsLocalCode; // 지역코드
    private String rtmsName;    // 상호
    private long rtmsFloor;     // 층.
    private String rtmsSeq; // 일련번호
    private double rtmsAreaSize;    // 면적
    private String rtmsRaw; // 근본 데이터.

    public RTMSDao() {

    }

    public RTMSDao(Map<String, Object> m) {

        //거래금액=   105,000,
        this.rtmsDealMoney = DataKrUtil.getDataKrLong(m.get("거래금액"));
        // 건축년도=2008.0,
        this.rtmsBullingYY = DataKrUtil.getDataKrCnvertDoubleToInt(m.get("건축년도"));
        // 년=2017.0,
        this.rtmsDealYY = DataKrUtil.getDataKrCnvertDoubleToInt(m.get("년"));
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
        // 도로명코드=4100135.0,
        this.rtmsLoadCode = ""+DataKrUtil.getDataKrCnvertDoubleToInt(m.get("도로명코드"));
        // 법정동=사직동,
        this.rtmsAreaName = DataKrUtil.getDataKrString(m.get("법정동"));
        // 법정동본번코드=0009,
        this.rtmsAreaNameCode = DataKrUtil.getDataKrDoubleToString(m.get("법정동본번코드"));
        // 법정동부번코드=0000,
        this.rtmsAreaNameSubCode = DataKrUtil.getDataKrDoubleToString(m.get("법정동부번코드"));
        // 법정동시군구코드=11110.0, 법정동읍면동코드=11500.0, 법정동지번코드=1.0,
        // 아파트=광화문풍림스페이스본(9-0),
        this.rtmsName = DataKrUtil.getDataKrString(m.get("아파트"));
        // 월=6.0,
        this.rtmsDealMM = DataKrUtil.getDataKrCnvertDoubleToInt(m.get("월"));
        // 일=11~20,
        this.rtmsDealDD = DataKrUtil.getDataKrString(m.get("일"));
        // 일련번호=11110-2203,
        this.rtmsSeq = DataKrUtil.getDataKrString(m.get("일련번호"));
        // 전용면적=146.92,
        this.rtmsAreaSize = DataKrUtil.getDataKrDouble(m.get("전용면적"));
        // 지번=9.0,
        // 지역코드=11110.0,
        this.rtmsLocalCode = DataKrUtil.getDataKrCnvertDoubleToInt(m.get("지역코드"));
        // 층=6.0}
        this.rtmsFloor = DataKrUtil.getDataKrCnvertDoubleToInt(m.get("층"));

        this.rtmsRaw = m.toString();
    }


    public int getRtmsNo() {
        return rtmsNo;
    }

    public void setRtmsNo(int rtmsNo) {
        this.rtmsNo = rtmsNo;
    }

    public int getRtmsBullingYY() {
        return rtmsBullingYY;
    }

    public void setRtmsBullingYY(int rtmsBullingYY) {
        this.rtmsBullingYY = rtmsBullingYY;
    }

    public long getRtmsDealMoney() {
        return rtmsDealMoney;
    }

    public void setRtmsDealMoney(long rtmsDealMoney) {
        this.rtmsDealMoney = rtmsDealMoney;
    }

    public int getRtmsDealYY() {
        return rtmsDealYY;
    }

    public void setRtmsDealYY(int rtmsDealYY) {
        this.rtmsDealYY = rtmsDealYY;
    }

    public long getRtmsDealMM() {
        return rtmsDealMM;
    }

    public void setRtmsDealMM(int rtmsDealMM) {
        this.rtmsDealMM = rtmsDealMM;
    }

    public String getRtmsDealDD() {
        return rtmsDealDD;
    }

    public void setRtmsDealDD(String rtmsDealDD) {
        this.rtmsDealDD = rtmsDealDD;
    }

    public String getRtmsLoadName() {
        return rtmsLoadName;
    }

    public void setRtmsLoadName(String rtmsLoadName) {
        this.rtmsLoadName = rtmsLoadName;
    }

    public String getRtmsLoadMainNum() {
        return rtmsLoadMainNum;
    }

    public void setRtmsLoadMainNum(String rtmsLoadMainNum) {
        this.rtmsLoadMainNum = rtmsLoadMainNum;
    }

    public String getRtmsLoadSubNum() {
        return rtmsLoadSubNum;
    }

    public void setRtmsLoadSubNum(String rtmsLoadSubNum) {
        this.rtmsLoadSubNum = rtmsLoadSubNum;
    }

    public String getRtmsLoadNum() {
        return rtmsLoadNum;
    }

    public void setRtmsLoadNum(String rtmsLoadNum) {
        this.rtmsLoadNum = rtmsLoadNum;
    }

    public String getRtmsLoadCode() {
        return rtmsLoadCode;
    }

    public void setRtmsLoadCode(String rtmsLoadCode) {
        this.rtmsLoadCode = rtmsLoadCode;
    }

    public String getRtmsAreaName() {
        return rtmsAreaName;
    }

    public void setRtmsAreaName(String rtmsAreaName) {
        this.rtmsAreaName = rtmsAreaName;
    }

    public String getRtmsAreaNameCode() {
        return rtmsAreaNameCode;
    }

    public void setRtmsAreaNameCode(String rtmsAreaNameCode) {
        this.rtmsAreaNameCode = rtmsAreaNameCode;
    }

    public String getRtmsAreaNameSubCode() {
        return rtmsAreaNameSubCode;
    }

    public void setRtmsAreaNameSubCode(String rtmsAreaNameSubCode) {
        this.rtmsAreaNameSubCode = rtmsAreaNameSubCode;
    }

    public long getRtmsLocalCode() {
        return rtmsLocalCode;
    }

    public void setRtmsLocalCode(long rtmsLocalCode) {
        this.rtmsLocalCode = rtmsLocalCode;
    }

    public String getRtmsName() {
        return rtmsName;
    }

    public void setRtmsName(String rtmsName) {
        this.rtmsName = rtmsName;
    }

    public long getRtmsFloor() {
        return rtmsFloor;
    }

    public void setRtmsFloor(long rtmsFloor) {
        this.rtmsFloor = rtmsFloor;
    }

    public String getRtmsSeq() {
        return rtmsSeq;
    }

    public void setRtmsSeq(String rtmsSeq) {
        this.rtmsSeq = rtmsSeq;
    }

    public double getRtmsAreaSize() {
        return rtmsAreaSize;
    }

    public void setRtmsAreaSize(double rtmsAreaSize) {
        this.rtmsAreaSize = rtmsAreaSize;
    }

    public String getRtmsRaw() {
        return rtmsRaw;
    }

    public void setRtmsRaw(String rtmsRaw) {
        this.rtmsRaw = rtmsRaw;
    }

    @Override
    public String toString() {
        return "RTMSDao{" +
                "rtmsNo=" + rtmsNo +
                ", rtmsBullingYY=" + rtmsBullingYY +
                ", rtmsDealMoney=" + rtmsDealMoney +
                ", rtmsDealYY=" + rtmsDealYY +
                ", rtmsDealMM=" + rtmsDealMM +
                ", rtmsDealDD='" + rtmsDealDD + '\'' +
                ", rtmsLoadName='" + rtmsLoadName + '\'' +
                ", rtmsLoadMainNum='" + rtmsLoadMainNum + '\'' +
                ", rtmsLoadSubNum='" + rtmsLoadSubNum + '\'' +
                ", rtmsLoadNum='" + rtmsLoadNum + '\'' +
                ", rtmsLoadCode='" + rtmsLoadCode + '\'' +
                ", rtmsAreaName='" + rtmsAreaName + '\'' +
                ", rtmsAreaNameCode='" + rtmsAreaNameCode + '\'' +
                ", rtmsAreaNameSubCode='" + rtmsAreaNameSubCode + '\'' +
                ", rtmsLocalCode=" + rtmsLocalCode +
                ", rtmsName='" + rtmsName + '\'' +
                ", rtmsFloor=" + rtmsFloor +
                ", rtmsSeq='" + rtmsSeq + '\'' +
                ", rtmsAreaSize=" + rtmsAreaSize +
                ", rtmsRaw='" + rtmsRaw + '\'' +
                '}';
    }
}
