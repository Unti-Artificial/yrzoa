package com.yrz.oa.core.controller;


import com.yrz.oa.core.po.*;
import com.yrz.oa.core.service.ClockService;
import com.yrz.oa.core.service.OaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/oaSystem")
public class ClockController {
    @Autowired
    private ClockService clockService;
    @Autowired
    private OaUserService oaUserService;

    /**
     * @param clock
     * @param clockTime
     * @return
     * @description 上班打卡
     */
    @RequestMapping(value = "/clockIn.action")
    @ResponseBody
    public String clockIn(Clock clock, ClockTime clockTime,
                          ClockToday clockToday,
                          ClockOverTime clockOverTime,
                          ClockOver clockOver, String userName) throws ParseException {
        Date date = new Date();
        Date presentTime = new Date();
        Date date1 = new Date();//获取的当前时间
        Date date2 = new Date();//打卡时间范围，若超出则会被计入迟到表
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String present = simpleDateFormat.format(date); //获取当前打卡时间
        //查询当天打卡时间，并对今天是否能继续打卡做出判断
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat1.format(presentTime);
        Integer todayDegree = clockService.selectIfOrNotClock(today);
//        Integer presentOverDegree = clockService.selectOverDegree(present, userName);
        //对当前打卡时间和打卡规定时间做比较 判断是否迟到
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        date1 = f.parse(f.format(new Date()));
        date2 = f.parse(d.format(new Date()) + " " + "08:00:00");//设置当天最迟打卡时间
        if (date1.getTime() < date2.getTime()) {
            if (todayDegree == null || todayDegree == 0) {
                //  table clock
                clock.setClockCreateTime(present);
                clock.setClockUser(userName);
                //table clock_time
                clockTime.setClockInCreateTime(present);
                clockTime.setClockUserName(userName);
                clockTime.setClockInDegree(1);
                int row1 = clockService.ClockIn(clock);
                int row2 = clockService.ClockInTime(clockTime);
                int row3 = clockService.ClockToday(clockToday);
                if (row1 > 0 && row2 > 0 && row3 >0) {
                    return "success";
                } else {
                    return "failure";
                }
            } else if (todayDegree == 1) {
                return "clocked";
            } else {
                return "null";
            }
        } else {
            if (todayDegree == null || todayDegree == 0) {
                //table clock_over
                clockOver.setClockUser(userName);
                clockOver.setClockOverCreateTime(present);
                // table clock_overtime
                clockOverTime.setClockUserName(userName);
                clockOverTime.setClockOverCreateTime(present);
                clockOverTime.setClockOverDegree(1);
                //table clock_today
                clockToday.setUserName(userName);
                clockToday.setClockCreateTime(today);
                clockToday.setTodayDegree(1);
                int row1 = clockService.ClockOverTime(clockOverTime);
                int row2 = clockService.ClockOver(clockOver);
                int row3 = clockService.ClockToday(clockToday);
                if (row1 > 0 && row2 > 0 && row3 >0) {
                    return "late";
                } else {
                    return "late failure";
                }
            } else if (todayDegree == 1) {
                return "late clocked";
            } else {
                return "null";
            }
        }
    }

    @RequestMapping(value = "clockOut.action")
    public String clockOut(){
        Date date = new Date();
        Date present = new Date();//获取的当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.format(date);
        return "";
    }
    /**
     * @param username
     * @param date
     * @return
     */
    @RequestMapping(value = "/doFindClockInf")
    public String doFindClockInf(String username, String date, Model model){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String endDate = sdf.format(today);//当前日期
        Calendar theCa = Calendar.getInstance();
        theCa.setTime(today);
        theCa.add(theCa.DATE, -30);
        Date start = theCa.getTime();
        date = sdf.format(start);
        System.out.println(date);
        Integer normalTime = clockService.selectTotalByNameAndDate(username, date);
        Integer lateTime = clockService.selectTotalOverByNameAndDate(username, date);
        Integer monthTime = normalTime + lateTime;
        model.addAttribute("normalTime", normalTime);
        model.addAttribute("lateTime", lateTime);
        return "admin/clockInf";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/selectIfOrNotClock.action")
    public String selectIfOrNotClock(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = simpleDateFormat.format(date);
        Integer todayClock = clockService.selectIfOrNotClock(today);
        return "";
    }
}