package com.yrz.oa.core.service;

import com.yrz.oa.core.po.*;
import org.apache.ibatis.annotations.Param;

public interface ClockService {
    //打卡
    int ClockIn(Clock clock);
    //迟到打卡
    int ClockOver(ClockOver clockOver);
    //添加当月打卡次数
    int ClockInTime(ClockTime clockTime);
    // 添加至迟到表
    int ClockOverTime(ClockOverTime clockOverTime);
    //添加到每天的考勤表
    int ClockInToday(ClockToday clockToday);
    // 根据用户名和每月查询当月打卡总数
    Integer selectTotalByNameAndDate(String username,String date);
    // 根据用户名和每月查询当月迟到打卡总数
   Integer  selectTotalOverByNameAndDate(String username,String date);
    //如果当天打卡次数出现重复情况 先通过查询
    Integer selectDegree(String present,String userName);
   //如果当天迟到打卡次数出现重复情况 先通过查询
    Integer selectOverDegree(String present,String userName);
    //查询员工当天是否打卡
    Integer selectIfOrNotClock(String today,String userName);
    //下班操作
    int ClockOutToday(ClockToday clockToday);
    int ClockOutTime(ClockOutTime clockOutTime);
    int ClockOut(ClockOut clockOut);
    Integer selectIfOrNotClockOut(String today,String userName);
}
