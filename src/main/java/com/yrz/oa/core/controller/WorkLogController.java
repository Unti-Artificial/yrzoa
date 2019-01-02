package com.yrz.oa.core.controller;

import com.yrz.oa.core.po.WorkLog;
import com.yrz.oa.core.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/oaSystem")
public class WorkLogController {
     @Autowired
     private WorkLogService workLogService;

     @RequestMapping(value = "workLogList.action")
     public String selectWorkLogListByName(String user, Model model){
          List<WorkLog> workLogs = workLogService.selectWorkLogListByName(user);
          model.addAttribute("logList",workLogs);
          return "admin/workLogInf";
     }

}
