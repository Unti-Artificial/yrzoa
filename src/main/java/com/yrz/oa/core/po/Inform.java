package com.yrz.oa.core.po;

public class Inform {
    private Integer informId;
    private String informContent;
    private String informUserName;
    private String informCreateTime;
    private String informTitle;

    public String getInformTitle() {
        return informTitle;
    }

    public void setInformTitle(String informTitle) {
        this.informTitle = informTitle;
    }

    public Integer getInformId() {
        return informId;
    }

    public void setInformId(Integer informId) {
        this.informId = informId;
    }

    public String getInformContent() {
        return informContent;
    }

    public void setInformContent(String informContent) {
        this.informContent = informContent;
    }

    public String getInformUserName() {
        return informUserName;
    }

    public void setInformUserName(String informUserName) {
        this.informUserName = informUserName;
    }

    public String getInformCreateTime() {
        return informCreateTime;
    }

    public void setInformCreateTime(String informCreateTime) {
        this.informCreateTime = informCreateTime;
    }
}
