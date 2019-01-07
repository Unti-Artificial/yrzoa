package com.yrz.oa.core.po;

public class Failure {
    private Integer applyId;  //申请人id
    private String finalApproveUser; //最终审批人
    private String finalApproveLevel;//最终审批一级
    private String applyUser;//申请人姓名
   private String finalApproveReason;//不让其通过原因

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getFinalApproveUser() {
        return finalApproveUser;
    }

    public void setFinalApproveUser(String finalApproveUser) {
        this.finalApproveUser = finalApproveUser;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getFinalApproveReason() {
        return finalApproveReason;
    }

    public void setFinalApproveReason(String finalApproveReason) {
        this.finalApproveReason = finalApproveReason;
    }

    public String getFinalApproveLevel() {
        return finalApproveLevel;
    }

    public void setFinalApproveLevel(String finalApproveLevel) {
        this.finalApproveLevel = finalApproveLevel;
    }
}
