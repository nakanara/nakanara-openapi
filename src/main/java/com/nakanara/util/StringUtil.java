package com.nakanara.util;

/**
 * Created by steg on 2017-06-22.
 */
public class StringUtil {
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
}
