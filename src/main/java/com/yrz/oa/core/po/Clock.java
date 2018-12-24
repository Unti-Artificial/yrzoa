package com.yrz.oa.core.po;

public class Clock {
    private String ClockUser;//打卡人姓名
    private String ClockCreateTime;//打卡时间

    public String getClockUser() {
        return ClockUser;
    }

    public void setClockUser(String clockUser) {
        ClockUser = clockUser;
    }

    public String getClockCreateTime() {
        return ClockCreateTime;
    }

    public void setClockCreateTime(String clockCreateTime) {
        ClockCreateTime = clockCreateTime;
    }
}
