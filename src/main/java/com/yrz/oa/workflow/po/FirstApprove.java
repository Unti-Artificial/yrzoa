package com.yrz.oa.workflow.po;

public class FirstApprove {
    private Integer firstApproveId;  //与applyId相对应
    private String firstApproveName; //审批人
    private String firstApproveTime; //审批时间
    private String firstApproveResult; //审批结果(“failure”,”success”)
    public Integer getFirstApproveId() {
        return firstApproveId;
    }

    public void setFirstApproveId(Integer firstApproveId) {
        this.firstApproveId = firstApproveId;
    }

    public String getFirstApproveName() {
        return firstApproveName;
    }

    public void setFirstApproveName(String firstApproveName) {
        this.firstApproveName = firstApproveName;
    }

    public String getFirstApproveTime() {
        return firstApproveTime;
    }

    public void setFirstApproveTime(String firstApproveTime) {
        this.firstApproveTime = firstApproveTime;
    }

    public String getFirstApproveResult() {
        return firstApproveResult;
    }

    public void setFirstApproveResult(String firstApproveResult) {
        this.firstApproveResult = firstApproveResult;
    }
}
