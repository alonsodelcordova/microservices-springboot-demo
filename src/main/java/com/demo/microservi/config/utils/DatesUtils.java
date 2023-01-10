package com.demo.microservi.config.utils;

import java.util.Date;

public class DatesUtils {
    public static Date sumDates(int nDates){
        Long sumNumDate = Long.valueOf((1000 * 60 * 60 * 24) * nDates);
        Date dt = new Date();
        Date tomorrow = new Date(dt.getTime() + sumNumDate);
        return tomorrow;
    }
}
