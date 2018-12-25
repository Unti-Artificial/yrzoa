package com.yrz.oa.core.po;

public class ClockOver {
    private String ClockUser; //迟到人姓名
    private String ClockOverCreateTime;//时间

    public String getClockOverCreateTime() {
        return ClockOverCreateTime;
    }

    public void setClockOverCreateTime(String clockOverCreateTime) {
        ClockOverCreateTime = clockOverCreateTime;
    }

    public String getClockUser() {
        return ClockUser;
    }

    public void setClockUser(String clockUser) {
        ClockUser = clockUser;
    }
}
