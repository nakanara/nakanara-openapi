package com.nakanara.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by steg on 2017-06-23.
 */
public class DataKrUtil {

    static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public static int getDataKrInt(Object o) {
        String s = "";
        int l = 0;

        try{
            s = (String)o;
            s = s.replaceAll(",", "");
            l = Integer.parseInt(s.trim());
        }catch(ClassCastException cce){
            logger.error("getDataKrInt Error {}", cce);
        }
        return l;
    }

    public static long getDataKrLong(Object o) {
        String s = "";
        long l = 0L;

        try{
            s = (String)o;
            s = s.replaceAll(",", "");
            l = Long.parseLong(s.trim());
        }catch(ClassCastException cce){
            logger.error("getDataKrLong Error {} orgVal: {}", cce, o);
        }
        return l;
    }

    public static double getDataKrDouble(Object o) {
        String s = "";
        double l = 0;

        try{
            l = (Double) o;
        }catch(ClassCastException cce){
            logger.error("getDataKrDouble Error {}", cce);
        }
        return l;
    }

    public static int getDataKrCnvertDoubleToInt(Object o) {
        double l = 0;
        int i=0;

        try{
            l = (Double) o;
            i = (int)l;
        }catch(ClassCastException cce){
            logger.error("getDataKrDouble Error {}", cce);
        }
        return i;
    }

    public static String getDataKrString(Object o) {
        String s = "";

        try{
            s = (String) o;
        }catch(ClassCastException cce){
            logger.error("getDataKrString Error {} orgVal {} ", cce, o);
        }
        return s.trim();
    }

    public static String getDataKrDoubleToString(Object o){
        double l = 0;
        String s= "";

        try{
            if(o instanceof Double) {
                l = (Double) o;
                s = String.valueOf(l);
            } else {
                s = (String) o;
            }
        }catch(ClassCastException cce){
            logger.error("getDataKrDouble Error {} org: {}", cce, o);
        }
        return s;
    }
}
