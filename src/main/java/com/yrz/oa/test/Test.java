package com.yrz.oa.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class Test {


    private static Logger logger =Logger.getLogger("Test.class");

    public static void main(String[] args) throws ParseException {
        Date date1 = new Date();
        Date date2 = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//sss
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");//ssss
        date1 = f.parse(f.format(new Date()));//获取当前的时间
        date2 = d.parse(d.format(new Date()) + " " + "17:30:00");//下班打卡的时间
        System.out.println(date2);
        Integer i = date1.compareTo(date2);
        if (i>0)
        {
            System.out.println("可以打卡");
        }else {
            System.out.println("不能打卡");
        }
    }

}
