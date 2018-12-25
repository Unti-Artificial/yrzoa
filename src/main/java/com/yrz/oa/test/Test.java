package com.yrz.oa.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class Test {


    private static Logger logger =Logger.getLogger("Test.class");

    public static void main(String[] args) throws ParseException {
        String beginTime=new String("2014-08-15 10:22:22");
        String endTime=new String("2014-09-02 11:22:22");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(beginTime);
        Date date1 = sdf.parse(endTime);
        if (date.before(date1)){
            System.out.println("打卡成功，今日已经迟到");
        }
    }

}
