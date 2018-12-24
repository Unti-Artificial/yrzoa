package com.yrz.oa.core.po;

public class ClockOver {
    private String ClockUser; //迟到人姓名
    private String ClockOverTime;//时间

    public String getClockOverTime() {
        return ClockOverTime;
    }

    public void setClockOverTime(String clockOverTime) {
        ClockOverTime = clockOverTime;
    }

    public String getClockUser() {
        return ClockUser;
    }

    public void setClockUser(String clockUser) {
        ClockUser = clockUser;
    }
}
