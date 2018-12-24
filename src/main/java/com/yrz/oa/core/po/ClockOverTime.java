package com.yrz.oa.core.po;

public class ClockOverTime {
    private String ClockUserName;//打卡人姓名
    private Integer ClockOverDegree;//迟到次数
    private String ClockOverCreateTime;//迟到时间

    public String getClockUserName() {
        return ClockUserName;
    }

    public void setClockUserName(String clockUserName) {
        ClockUserName = clockUserName;
    }

    public Integer getClockOverDegree() {
        return ClockOverDegree;
    }

    public void setClockOverDegree(Integer clockOverDegree) {
        ClockOverDegree = clockOverDegree;
    }

    public String getClockOverCreateTime() {
        return ClockOverCreateTime;
    }

    public void setClockOverCreateTime(String clockOverCreateTime) {
        ClockOverCreateTime = clockOverCreateTime;
    }
}
