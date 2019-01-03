package com.yrz.oa.workflow.controller;

import com.yrz.oa.workflow.po.Apply;
import com.yrz.oa.workflow.service.ApplyService;
import com.yrz.oa.workflow.service.WorkFlowService;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/oaSystem")
public class WorkFlowController {
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private ApplyService applyService;

    @RequestMapping(value = "startApply")
    @ResponseBody
    public String startApply(Apply apply) {
        Integer applyRow = applyService.StartApply(apply);
        if (applyRow > 0) {
            return "success";
        } else {
            return "failure";
        }
    }

    @RequestMapping(value = "")
    public String startFirstApprove() {

        return "";
    }
}
