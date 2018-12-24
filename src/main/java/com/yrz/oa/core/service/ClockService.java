package com.yrz.oa.core.service;

import com.yrz.oa.core.po.Clock;
import com.yrz.oa.core.po.ClockOver;
import com.yrz.oa.core.po.ClockOverTime;
import com.yrz.oa.core.po.ClockTime;
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
    // 根据用户名和每月查询当月打卡总数
    Integer selectTotalByNameAndDate(String username,String date);
    // 根据用户名和每月查询当月迟到打卡总数
   Integer  selectTotalOverByNameAndDate(String username,String date);
    //如果当天打卡次数出现重复情况 先通过查询
    Integer selectDegree(String present,String userName);
   //如果当天迟到打卡次数出现重复情况 先通过查询
    Integer selectOverDegree(String present,String userName);
}
