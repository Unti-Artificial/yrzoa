package com.yrz.oa.workflow.po;

public class Apply {
    private Integer applyId;//主键
    private String applyUser;//申请人
    private String applyCreateTime; //申请时间
    private String applyState; //申请状态 (0:申请还未提交,1:申请提交,2:申请提交且被提交至下一层审批3:申请被驳回)
    private String applyContent;//申请备注
    private String  applyTitle; //申请标题(申请标题)
    private String applyFinalResult;

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyCreateTime() {
        return applyCreateTime;
    }

    public void setApplyCreateTime(String applyCreateTime) {
        this.applyCreateTime = applyCreateTime;
    }

    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }

    public String getApplyContent() {
        return applyContent;
    }

    public void setApplyContent(String applyContent) {
        this.applyContent = applyContent;
    }

    public String getApplyTitle() {
        return applyTitle;
    }

    public void setApplyTitle(String applyTitle) {
        this.applyTitle = applyTitle;
    }

    public String getApplyFinalResult() {
        return applyFinalResult;
    }

    public void setApplyFinalResult(String applyFinalResult) {
        this.applyFinalResult = applyFinalResult;
    }
}
