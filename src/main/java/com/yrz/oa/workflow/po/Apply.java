package com.yrz.oa.workflow.po;

public class Apply {
    private Integer applyId;//主键
    private String applyUser;//申请人
    private String applyCreateTime; //申请时间
    private String applyFirstState; //申请状态 (1:申请提交未被审批,2:申请通过且被提交至下一层审批3:申请被驳回)
    private String applySecondState;//申请状态(1:申请提交未被审批,2:申请通过且被提交至下一层审批3:申请被驳回)
    private String applyThirdState;//申请状态(1:申请提交未被审批2:申请已经通过;3:申请被驳回)
    private String applyContent;//申请备注
    private String  applyTitle; //申请标题(申请标题)

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

    public String getApplyFirstState() {
        return applyFirstState;
    }

    public void setApplyFirstState(String applyFirstState) {
        this.applyFirstState = applyFirstState;
    }

    public String getApplySecondState() {
        return applySecondState;
    }

    public void setApplySecondState(String applySecondState) {
        this.applySecondState = applySecondState;
    }

    public String getApplyThirdState() {
        return applyThirdState;
    }

    public void setApplyThirdState(String applyThirdState) {
        this.applyThirdState = applyThirdState;
    }
}
