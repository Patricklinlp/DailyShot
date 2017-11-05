package com.lp.dailyshot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Patrick on 2017/11/5.
 */

public class DateUtil {

    private static final DateFormat MY_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static String today() {
        return MY_DATE_FORMAT.format(new Date());
    }


}
