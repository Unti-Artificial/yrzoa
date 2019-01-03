package com.yrz.oa.workflow.po;

public class FirstApproveFailure {
    private Integer firstApproveId;
    private Integer applyId;
    private  String firstApproveUser;
    private  String firstApproveReason;
    private  String firstApproveCreateTime;

    public Integer getFirstApproveId() {
        return firstApproveId;
    }

    public void setFirstApproveId(Integer firstApproveId) {
        this.firstApproveId = firstApproveId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getFirstApproveUser() {
        return firstApproveUser;
    }

    public void setFirstApproveUser(String firstApproveUser) {
        this.firstApproveUser = firstApproveUser;
    }

    public String getFirstApproveReason() {
        return firstApproveReason;
    }

    public void setFirstApproveReason(String firstApproveReason) {
        this.firstApproveReason = firstApproveReason;
    }

    public String getFirstApproveCreateTime() {
        return firstApproveCreateTime;
    }

    public void setFirstApproveCreateTime(String firstApproveCreateTime) {
        this.firstApproveCreateTime = firstApproveCreateTime;
    }
}
