package com.yrz.oa.core.controller;


import com.yrz.oa.core.po.Inform;
import com.yrz.oa.core.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/oaSystem")
public class InformController {
    @Autowired
    private InformService informService;

    @RequestMapping(value = "/getInformContent.action")
    @ResponseBody
    public Inform getInformContent(Integer id){
        Inform inform = informService.getInformContent(id);
        return inform;
    }

    @RequestMapping(value = "/updateInform.action")
    @ResponseBody
    public String updateInform(String content){
      Integer row = informService.updateInform(content);
      if (row > 0) {
          return "success";
      } else{
          return "false";
      }
    }

    @RequestMapping(value = "/publishInform.action")
    @ResponseBody
    public String publishInform(Inform inform){
        Integer row = informService.publishInform(inform);
        if (row > 0){
            return "success";
        }else {
            return "false";
        }
    }
}
