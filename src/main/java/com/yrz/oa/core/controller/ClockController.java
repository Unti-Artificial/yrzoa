package com.yrz.oa.core.controller;


import com.yrz.oa.core.po.Clock;
import com.yrz.oa.core.po.ClockOver;
import com.yrz.oa.core.po.ClockOverTime;
import com.yrz.oa.core.po.ClockTime;
import com.yrz.oa.core.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/oaSystem")
public class ClockController {
    @Autowired
    private ClockService clockService;

    /**
     * @param clock
     * @param clockTime
     * @description 打卡
     * @return
     */
    @RequestMapping("/clockIn.action")
    @ResponseBody
    public String clockIn(Clock clock, ClockTime clockTime, ClockOverTime clockOverTime, ClockOver clockOver, String userName) throws ParseException {
        Date date = new Date();
        Date date1 = new Date();//获取的当前时间
        Date date2 = new Date();//打卡时间范围，若超出则会被计入迟到表
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String present = simpleDateFormat.format(date); //获取当前打卡时间
        //查询当天打卡时间，并对今天是否能继续打卡做出判断
        Integer presentDegree = clockService.selectDegree(present, userName);
        Integer presentOverDegree = clockService.selectOverDegree(present,userName);
        //对当前打卡时间和打卡规定时间做比较 判断是否迟到
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        date1 = f.parse(f.format(new Date()));
        date2 = f.parse(d.format(new Date()) + " " + "08:00:00");
        if (date1.getTime() < date2.getTime()) {
            if (presentDegree == null || presentDegree == 0) {
                //  table clock
                clock.setClockCreateTime(present);
                clock.setClockUser(userName);
                //table clock_time
                clockTime.setClockInCreateTime(present);
                clockTime.setClockUserName(userName);
                clockTime.setClockInDegree(1);
                int row1 = clockService.ClockIn(clock);
                int row2 = clockService.ClockInTime(clockTime);
                if (row1 > 0 && row2 > 0) {
                    return "success";
                } else {
                    return "failure";
                }
            } else if (presentDegree == 1) {
                return "clocked";
            } else {
                return "null";
            }
        }
        else {
            if (presentOverDegree == null || presentOverDegree == 0) {
                //table clock_over
                clockOver.setClockUser(userName);
                clockOver.setClockOverTime(present);
                // table clock_overtime
                clockOverTime.setClockUserName(userName);
                clockOverTime.setClockOverCreateTime(present);
                clockOverTime.setClockOverDegree(1);
                int row1 = clockService.ClockOverTime(clockOverTime);
                int row2 = clockService.ClockOver(clockOver);
                if (row1 > 0 && row2 > 0) {
                    return "late";
                } else {
                    return "late failure";
                }
            }else if (presentOverDegree == 1){
                 return "late clocked";
            }
            else {
                return "null" ;
            }
        }
    }

    /**
     * @param username
     * @param date
     * @return
     */
    @RequestMapping("/findTotal.action")
    @ResponseBody
    public Integer findTotal(String username, String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String date1 = simpleDateFormat.format(date);
        Integer TotalTime = clockService.selectTotalByNameAndDate(username, date1);
        return TotalTime;
    }
}