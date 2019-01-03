package com.yrz.oa.workflow.po;

public class ThirdResult {
    private Integer thirdResultId;
    private Integer applyId;
    private String secondResult;
    private String resultCreateTime;

    public Integer getThirdResultId() {
        return thirdResultId;
    }

    public void setThirdResultId(Integer thirdResultId) {
        this.thirdResultId = thirdResultId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getSecondResult() {
        return secondResult;
    }

    public void setSecondResult(String secondResult) {
        this.secondResult = secondResult;
    }

    public String getResultCreateTime() {
        return resultCreateTime;
    }

    public void setResultCreateTime(String resultCreateTime) {
        this.resultCreateTime = resultCreateTime;
    }
}
