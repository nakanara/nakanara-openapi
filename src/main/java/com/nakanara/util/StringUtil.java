package com.nakanara.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nakanara on 2017-06-22.
 */
public class StringUtil {

    static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 문자열이 빈값인지 여부.
     * @param v
     * @return
     */
    public static boolean isNotEmpty(String v) {
        if(v == null || v.length() == 0) return false;
        return true;
    }

    public static boolean isEmpty(String v) {
        if(v == null || v.length() == 0) return true;
        return false;
    }

    public static String objectToString(Object o) {
        String s = "";
        try{
            s = (String)o;
        }catch(ClassCastException cce){
            logger.error("ObjectToString Error {}", cce);
        }

        return s.trim();
    }

    public static long convertStringToLong(String s) {
        Long l = 0L;
        try {
            l = Long.parseLong(s);
        }catch(ClassCastException cce){
            logger.error("convertStringToLong Error {}", cce);
        }
        return l;
    }

}
