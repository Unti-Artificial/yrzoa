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
	public String login(String account,String password,Model model,
                                                          HttpSession session) {
		OaUser oaUser = oaUserService.doLogin(account, password);
		Integer userId = oaUser.getUserId();
		String userName = oaUser.getUserName();
		String userRole = oaUser.getUserRole();
		if (oaUser != null && userRole.equals("admin")) {
			String role = userRole.replace("admin","管理员");
			session.setAttribute("USER_SESSION",oaUser);
			model.addAttribute("userId",userId);
			model.addAttribute("userName", userName);
			model.addAttribute("userRole",role);
			return "admin/main";
		} else if (oaUser != null && userRole.equals("user")) {
			String role = userRole.replace("user","用户");
			userRole.replace("user","用户");
			session.setAttribute("USER_SESSION",oaUser);
			model.addAttribute("userId",userId);
			model.addAttribute("userName", userName);
			model.addAttribute("userRole",role);
			return "user/main";
		} else {
			model.addAttribute("msg", "用户名或密码错误，请重新输入登陆信息");
			return "login";
		}
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
	/**
	 *  查询自己所有的信息
 	 * @param userId
	 * @return
	 */
	//登陆用户查询自己的登陆信息
	@RequestMapping(value = "/doFindInf.action")
	@ResponseBody
	public OaUser doFindInf(Integer userId){
		OaUser oaUser = oaUserService.doFindIns(userId);
		return oaUser;
	}
	@RequestMapping(value = "Main.action")
	public String toMain(){
		return "admin/main";
	}
}
