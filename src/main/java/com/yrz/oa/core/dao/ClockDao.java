package com.yrz.oa.core.dao;

import com.yrz.oa.core.po.*;
import org.apache.ibatis.annotations.Param;

public interface ClockDao {
    //打卡
    int ClockIn(Clock clock);
    // 迟到打卡
    int ClockOver(ClockOver clockOver);
    //添加当月打卡次数
    int ClockInTime(ClockTime clockTime);
    //添加当月迟到打卡次数
    int ClockOverTime(ClockOverTime clockOverTime);
    //添加到每天的考勤表
     int ClockToday(ClockToday clockToday);
    // 根据用户名和每月查询当月正常打卡总数
    Integer selectTotalByNameAndDate(@Param("username") String username, @Param("date") String date);
    // 根据用户名和每月查询当月迟到打卡总数
    Integer  selectTotalOverByNameAndDate(@Param("username") String username, @Param("date") String date);
    //如果当天打卡次数出现重复情况 先通过查询
    Integer selectDegree(@Param("present")String present,@Param("userName")String userName);
   //如果当天打卡次数出现重复情况 先通过查询
    Integer selectOverDegree(@Param("present")String present,@Param("userName")String userName);
    //查询员工当天是否打卡
    Integer selectIfOrNotClock(@Param("today") String today);
}
