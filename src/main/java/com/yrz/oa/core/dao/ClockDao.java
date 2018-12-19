package com.yrz.oa.core.dao;

import com.yrz.oa.core.po.Clock;
import com.yrz.oa.core.po.ClockTime;
import org.apache.ibatis.annotations.Param;

public interface ClockDao {
    //打卡
    int ClockIn(Clock clock);

    //添加当月打卡次数
    int ClockInTime(ClockTime clockTime);

    // 根据用户名和每月查询当月打卡总数
    Integer selectTotalByNameAndDate(@Param("username") String username, @Param("date") String date);

    //如果当天打卡次数出现重复情况 先通过查询
    Integer selectDegree(@Param("present")String present,@Param("username")String username);

}
