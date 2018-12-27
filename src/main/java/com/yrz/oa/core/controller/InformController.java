package com.yrz.oa.core.controller;


import com.yrz.oa.core.po.Inform;
import com.yrz.oa.core.po.OaUser;
import com.yrz.oa.core.service.InformService;
import com.yrz.oa.core.service.OaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/oaSystem")
public class InformController {
    @Autowired
    private InformService informService;
    @Autowired
    private OaUserService oaUserService;

    /**
     *
     * @param inform
     * @description 更改通知内容
     */
    @RequestMapping(value = "/updateInform.action")
    @ResponseBody
    public String updateInform(Inform inform){
      Integer row = informService.updateInform(inform);
      if (row > 0) {
          return "success";
      } else{
          return "false";
      }
    }

    /**
     *
     * @param inform
     * @description 发布通知
     */
    @RequestMapping(value = "/addInform.action")
    @ResponseBody
    public String addInform(Inform inform){
        Integer row = informService.addInform(inform);
        if (row > 0){
            return "success";
        }else {
            return "false";
        }
    }

    @RequestMapping(value = "doFindInform.action")
    @ResponseBody
    public Inform getInformById(Integer InformId){
        Inform inform = informService.getInformById(InformId);
        return inform;
    }

    /**
     *
     * @param userId
     * @param model
     * @description 公告List
     */
    @RequestMapping(value = "showInform.action")
    public String toShowInform(Integer userId, Model model){
      OaUser oaUser = oaUserService.doFindOwnInf(userId);
        model.addAttribute("useName",oaUser.getUserName());
        model.addAttribute("userId",oaUser.getUserId());
        //do   select Inform table
        List<Inform> inform = informService.getAllInform();
        model.addAttribute("informList",inform);
        return "admin/informInf/showInform";
    }
}
