package com.itheima.oacore.controller;

import com.itheima.oacore.po.OaUser;
import com.itheima.oacore.service.OaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class OaUserController {
    @Autowired
    private OaUserService oaUserService;


    //用户登陆
    @RequestMapping(value = "/oaSystem/Login.action")
    public String oaLogin(HttpSession session, String account, String password, Model model,String role) {
        OaUser oaUser = oaUserService.doLogin(account, password,role);
        if (oaUser != null && oaUser.getUserRole().equals("admin")) {
            //如果是action得重定向
            session.setAttribute("ADMIN", oaUser);
            return "OA/admin/main";
        } else if (oaUser !=null && oaUser.getUserRole().equals("user")){
            session.setAttribute("USER",oaUser);
            return "OA/user/main";
        }
        else{
            model.addAttribute("msg","用户名、密码或身份出错,请重新填入登陆信息");
            return "OA/login";
        }
    }

    @RequestMapping(value = "/oaSystem/toLogin.action")
    public String toLogin() {
         return "OA/login";
    }
    @RequestMapping(value = "/oaSystem/LoginOut.action")
    public String LoginOut(HttpSession session){
     session.invalidate();
     return "OA/login";
    }
}
