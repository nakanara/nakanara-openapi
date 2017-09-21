package com.nakanara.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;


/**
 * Created by nakanara on 2017-06-26.
 */
public class StopWatchUtil {

    private static Logger logger = LoggerFactory.getLogger(StopWatchUtil.class);

    public static Calendar start(String tag) {
        Calendar startCal = Calendar.getInstance();

        logger.info("Start [{}] = {}", tag, StopWatchUtil.getFormat(startCal));

        return startCal;
    }

    public static Calendar stop(String tag, Calendar startCal) {
        Calendar stopCal = Calendar.getInstance();

        long cap = stopCal.getTimeInMillis() - startCal.getTimeInMillis();
        logger.info("Stop [{}] = {} / {} = {}sec", tag, StopWatchUtil.getFormat(startCal), StopWatchUtil.getFormat(stopCal), cap);

        return stopCal;
    }

    public static String getFormat(Calendar calendar) {
        String buf = "";
        int v = 0;

        buf = "" + calendar.get(Calendar.YEAR) + "-";

        v = calendar.get(Calendar.MONTH)+1;

        if(v > 10) buf += "" + v;
        else buf += "0" + v;
        buf += "-";

        v = calendar.get(Calendar.DATE);
        if( v > 10) buf += "" + v;
        else buf += "0" + v;

        buf += " ";

        v = calendar.get(Calendar.HOUR);
        if( v > 10) buf += "" + v;
        else buf += "0" + v;

        buf += ":";
        v = calendar.get(Calendar.MINUTE);
        if( v > 10) buf += "" + v;
        else buf += "0" + v;

        buf += ":";
        v = calendar.get(Calendar.SECOND);
        if( v > 10) buf += "" + v;
        else buf += "0" + v;

        return buf;
    }
}
