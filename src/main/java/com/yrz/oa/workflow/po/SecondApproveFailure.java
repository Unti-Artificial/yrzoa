package com.yrz.oa.workflow.po;

public class SecondApproveFailure {
    private Integer secondApproveId;
    private Integer applyId;
    private String secondApproveUser;
    private String secondApproveReason;
    private String secondApproveCreateTime;

    public Integer getSecondApproveId() {
        return secondApproveId;
    }

    public void setSecondApproveId(Integer secondApproveId) {
        this.secondApproveId = secondApproveId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getSecondApproveUser() {
        return secondApproveUser;
    }

    public void setSecondApproveUser(String secondApproveUser) {
        this.secondApproveUser = secondApproveUser;
    }

    public String getSecondApproveReason() {
        return secondApproveReason;
    }

    public void setSecondApproveReason(String secondApproveReason) {
        this.secondApproveReason = secondApproveReason;
    }

    public String getSecondApproveCreateTime() {
        return secondApproveCreateTime;
    }

    public void setSecondApproveCreateTime(String secondApproveCreateTime) {
        this.secondApproveCreateTime = secondApproveCreateTime;
    }
}
