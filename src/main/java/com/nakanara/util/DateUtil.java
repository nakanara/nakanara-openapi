package com.nakanara.util;

import java.util.Calendar;

/**
 * Created by steg on 2017-06-28.
 */
public class DateUtil {

    public static String getYYMM() {
        Calendar calendar = Calendar.getInstance();
        String yymm = "" + calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH) +1;

        if(mm >= 10) yymm += mm;
        else yymm += ("0" + mm);

        return yymm;
    }
}
