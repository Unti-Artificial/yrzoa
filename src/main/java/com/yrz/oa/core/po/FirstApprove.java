package com.yrz.oa.core.po;

public class FirstApprove {
    private Integer firstApproveId;  //与applyId相对应
    private String firstApproveUser; //审批人
    private String firstApproveTime; //审批时间
    private String firstApproveTitle;
    private String firstApproveContent;
    private String applyUser;
    public Integer getFirstApproveId() {
        return firstApproveId;
    }

    public void setFirstApproveId(Integer firstApproveId) {
        this.firstApproveId = firstApproveId;
    }

    public String getFirstApproveTime() {
        return firstApproveTime;
    }

    public void setFirstApproveTime(String firstApproveTime) {
        this.firstApproveTime = firstApproveTime;
    }

    public String getFirstApproveUser() {
        return firstApproveUser;
    }

    public void setFirstApproveUser(String firstApproveUser) {
        this.firstApproveUser = firstApproveUser;
    }

    public String getFirstApproveTitle() {
        return firstApproveTitle;
    }

    public void setFirstApproveTitle(String firstApproveTitle) {
        this.firstApproveTitle = firstApproveTitle;
    }

    public String getFirstApproveContent() {
        return firstApproveContent;
    }

    public void setFirstApproveContent(String firstApproveContent) {
        this.firstApproveContent = firstApproveContent;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }
}
