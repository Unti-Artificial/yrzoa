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
     *
     * @param clock
     * @param clockTime
     * @param clockToday
     * @param clockOverTime
     * @param clockOver
     * @param userName
     * @return
     * @throws ParseException
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
        //查询当天上班是否打卡
        Integer todayDegree = clockService.selectIfOrNotClock(today,userName);
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
                //table clock_today
                clockToday.setClockCreateTime(today);
                clockToday.setUserName(userName);
                clockToday.setTodayDegree(1);
                int row1 = clockService.ClockIn(clock);
                int row2 = clockService.ClockInTime(clockTime);
                int row3 = clockService.ClockInToday(clockToday);
                if (row1 > 0 && row2 > 0 && row3 > 0) {
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
                int row3 = clockService.ClockInToday(clockToday);
                if (row1 > 0 && row2 > 0 && row3 > 0) {
                    return "late";
                } else {
                    return "late failure";
                }
            } else if (todayDegree == 1) {
                return "late clocked";
            } else {
                System.out.println(todayDegree);
                return "null";
            }
        }
    }

    /**
     *
     * @param userName
     * @param clockOut
     * @param clockOutTime
     * @param clockToday
     * @return
     * @throws ParseException
     * @description 下班打卡
     */
    @RequestMapping(value = "clockOut.action")
    @ResponseBody
    public String clockOut(String userName
    ,ClockOut clockOut,ClockOutTime clockOutTime,ClockToday clockToday
    ) throws ParseException {
        Date presentTime = new Date();
        Date date1 = new Date();
        Date date2 = new Date();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat1.format(presentTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String present = simpleDateFormat.format(date); //获取当前打卡时间
        Integer todayOutDegree = clockService.selectIfOrNotClockOut(today,userName);
        date1 = f.parse(f.format(new Date()));//获取当前的时间
        date2 = f.parse(d.format(new Date()) + " " + "17:30:00");//下班打卡的时间
        System.out.println(date1);
        System.out.println(date2);
        if (date1.getTime()>date2.getTime()){
            //此时可以正常下班打卡
            if (todayOutDegree ==null || todayOutDegree ==0) {
                // table  clock_out
                clockOut.setClockOutCreateTime(present);
                clockOut.setClockUser(userName);
                // table clock_outtime
                clockOutTime.setClockOutCreateTime(present);
                clockOutTime.setClockOutDegree(1);
                clockOutTime.setClockUserName(userName);
                // table clock_today
                clockToday.setUserName(userName);
                clockToday.setTodayDegree(1);
                clockToday.setClockCreateTime(today);
                int row1 = clockService.ClockOut(clockOut);
                int row2 = clockService.ClockOutTime(clockOutTime);
                System.out.println(row2);
                int row3 = clockService.ClockOutToday(clockToday);
                if (row1 >0 && row2 >0 && row3 >0){
                       return "success";//下班打卡成功
                }else {
                    return "failure";//下班打卡失败 联系管理员
                }
            }else if (todayOutDegree ==1){
                   return "out clocked";//已经打过卡
                }else {
                   return "unknown error";//出现未知错误，请联系管理员
                }
        }else {
            return "time error";//未到规定时间，请17：30来打卡
        }

    }

    /**
     *
     * @param userId
     * @param model
     * @param date
     * @return
     */
    @RequestMapping("clockOwnInf.action")
    public String ClockOwnInf(Integer userId,Model model,String date){
        // start   before the month
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String endDate = sdf.format(today);//当前日期
        Calendar theCa = Calendar.getInstance();
        theCa.setTime(today);
        theCa.add(theCa.DATE, -30);
        Date start = theCa.getTime();
        date = sdf.format(start);
        // end
        OaUser oaUser = oaUserService.doFindOwnInf(userId);
        model.addAttribute("userName",oaUser.getUserName());
        model.addAttribute("userId",oaUser.getUserId());
        Integer normalClockTime = clockService.selectTotalByNameAndDate(oaUser.getUserName(),date);//上个月正常打卡次数
        Integer overClockTime = clockService.selectTotalOverByNameAndDate(oaUser.getUserName(),date);//上个月一共打卡的次数
        if (overClockTime == null){
            overClockTime = 0 ;
        }
        if (normalClockTime == null){
            normalClockTime = 0;
        }
        Integer altogetherTime = normalClockTime + overClockTime;
        model.addAttribute("normalClockTime",normalClockTime);
        model.addAttribute("overClockTime",overClockTime);
        model.addAttribute("altogetherTime",altogetherTime);
        model.addAttribute("startDate",date);
        model.addAttribute("endDate",endDate);
        return "admin/clockInf/clockOwnInf";
    }
    @RequestMapping(value = "clockInf.action")
    public String clockInf(){

        return "";
    }
}