package com.yrz.oa.core.po;

public class SecondResult {
   private Integer secondResultId;
   private Integer applyId;
   private String  secondResult;
   private String resultCreateTime;

    public Integer getSecondResultId() {
        return secondResultId;
    }

    public void setSecondResultId(Integer secondResultId) {
        this.secondResultId = secondResultId;
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
