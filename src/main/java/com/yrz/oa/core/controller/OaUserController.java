package com.yrz.oa.core.controller;



import com.yrz.oa.core.po.OaUser;
import com.yrz.oa.core.service.OaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 用户控制器类
 */
@Controller
@RequestMapping(value = "/oaSystem")
public class OaUserController {
	// 依赖注入
	@Autowired
	private OaUserService oaUserService;
	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/Login.action")
	public String login(String account,String password,String role ,Model model,
                                                          HttpSession session) {
		OaUser oaUser = oaUserService.doLogin(account, password, role);
		if (oaUser != null && oaUser.getUserRole().equals("admin")) {
			session.setAttribute("ADMIN", oaUser);
			return "admin/main";
		} else if (oaUser != null && oaUser.getUserRole().equals("user")) {
			session.setAttribute("USER", oaUser);
			return "user/main";
		} else {
			model.addAttribute("msg", "用户名，密码或者身份错误，请重新输入登陆信息");
			return "login";

		}
	}
	/**
	 * 模拟其他类中跳转到客户管理页面的方法
	 */
	@RequestMapping(value = "/toAdminMain.action")
	public String toAdminMain() {
    return "admin/main";
	}
	@RequestMapping(value = "/toUserMain.action")
	public String toUserMain() {
		return "user/main";
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/Logout.action")
	public String logout(HttpSession session) {
	    // 清除Session
	    session.invalidate();
	    // 重定向到登录页面的跳转方法
	    return "login";
	}
	/**
	 * 向用户登陆页面跳转
	 */
	@RequestMapping(value = "/toLogin.action")
	public String toLogin() {
	    return "login";
	}

	//登陆用户查询自己的登陆信息
	@RequestMapping(value = "/doFindInf.action")
	@ResponseBody
	public OaUser doFindInf(String username){
		OaUser oaUser = oaUserService.doFindIns(username);
		return oaUser;
	}
}
