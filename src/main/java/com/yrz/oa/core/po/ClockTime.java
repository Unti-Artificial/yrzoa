package com.yrz.oa.core.po;

import java.util.Date;

public class ClockTime {
    private String ClockUserName;//打卡人姓名
    private Integer ClockInDegree;//打卡次数
    private String ClockInCreateTime;//打卡时间

    public String getClockInCreateTime() {
        return ClockInCreateTime;
    }

    public void setClockInCreateTime(String clockInCreateTime) {
        ClockInCreateTime = clockInCreateTime;
    }

    public String getClockUserName() {
        return ClockUserName;
    }

    public void setClockUserName(String clockUserName) {
        ClockUserName = clockUserName;
    }

    public Integer getClockInDegree() {
        return ClockInDegree;
    }

    public void setClockInDegree(Integer clockInDegree) {
        ClockInDegree = clockInDegree;
    }
}
