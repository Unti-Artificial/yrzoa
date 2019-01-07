package com.yrz.oa.core.controller;

import com.yrz.oa.core.po.OaUser;
import com.yrz.oa.core.service.OaUserService;
import com.yrz.oa.core.po.Apply;
import com.yrz.oa.core.service.ApplyService;
import com.yrz.oa.core.service.WorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/oaSystem")
public class WorkFlowController {
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private OaUserService oaUserService;


    @RequestMapping(value = "/toApply.action")
    public String toApply(Integer userId, Model model){
        OaUser oaUser = oaUserService.doFindOwnInf(userId);
        model.addAttribute("userId",oaUser.getUserId());
        model.addAttribute("userName",oaUser.getUserName());
           return "admin/startApprove";
    }

    @RequestMapping(value = "/startApply.action")
    @ResponseBody
    public String startApply(String applyTitle,String applyUser,String applyContent,String applyCreateTime) {
        Apply apply = new Apply();
        apply.setApplyTitle(applyTitle);
        apply.setApplyContent(applyContent);
        apply.setApplyUser(applyUser);
        apply.setApplyCreateTime(applyCreateTime);
        apply.setApplyFirstState("0");
        apply.setApplySecondState("0");
        apply.setApplyThirdState("0");
        Integer applyRow = applyService.startApply(apply);
        if (applyRow > 0) {
            return "success";
        } else {
            return "failure";
        }
    }

    @RequestMapping(value = "/comeInFirstApprove.action")
    public String startFirstApprove(){
        List<Apply> applyList = workFlowService.selectNotDealWithFirstApply();
        for (Apply apply:applyList){
             apply.getApplyId();
        }
        return "";
    }
}
