package com.yrz.oa.core.po;

public class ClockOutTime {
    private String ClockUserName;//打卡人姓名
    private Integer ClockOutDegree;//下班打卡次数
    private String ClockOutCreateTime;//下班时间

    public String getClockUserName() {
        return ClockUserName;
    }

    public void setClockUserName(String clockUserName) {
        ClockUserName = clockUserName;
    }

    public Integer getClockOutDegree() {
        return ClockOutDegree;
    }

    public void setClockOutDegree(Integer clockOutDegree) {
        ClockOutDegree = clockOutDegree;
    }

    public String getClockOutCreateTime() {
        return ClockOutCreateTime;
    }

    public void setClockOutCreateTime(String clockOutCreateTime) {
        ClockOutCreateTime = clockOutCreateTime;
    }
}
