package com.yrz.oa.core.controller;



import com.yrz.oa.core.po.OaUser;
import com.yrz.oa.core.service.OaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
	public String login(String account, String password, Model model,
						HttpSession session) {
		OaUser oaUser = oaUserService.doLogin(account, password);

		if (oaUser != null) {
			Integer userId = oaUser.getUserId();
			String userName = oaUser.getUserName();
			String userRole = oaUser.getUserRole();
			session.setAttribute("USER_NAME", oaUser.getUserName());
			session.setAttribute("USER_ROLE", oaUser.getUserRole());
			session.setAttribute("USER_ID", oaUser.getUserId());
			model.addAttribute("userId", userId);
			model.addAttribute("userName", userName);
			if (userRole.equals("admin")) {
				return "admin/main";
			}
			if (userRole.equals("user")) {
				return "user/main";
			}
			model.addAttribute("error1", "出现错误身份，请联系管理员");
		}
		model.addAttribute("error2", "账号或密码错误，请重新输入！");
		return "login";
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
	 * 查询自己所有的信息
	 *
	 * @param userId
	 * @return
	 */
	//登陆用户查询自己的登陆信息
	@RequestMapping(value = "/doFindOwnInf.action")
	public String doFindOwnInf(Integer userId,Model model) {
		  OaUser oaUser = oaUserService.doFindOwnInf(userId);
		  model.addAttribute("userId",oaUser.getUserId());
		  model.addAttribute("userAccount",oaUser.getUserAccount());
		  model.addAttribute("userPassword",oaUser.getUserPassword());
		  model.addAttribute("userEmail",oaUser.getUserEmail());
		  model.addAttribute("userPhone",oaUser.getUserPhone());
		  model.addAttribute("userName",oaUser.getUserName());
		  return "admin/userInf/userInf";
	}
	//用户修改自己的账户信息

	/**
	 *
	 * @param userId
	 * @param model
	 * @return
	 * @description 先查询
	 */
	@RequestMapping(value = "doEditOwnInf.action")
	public String doUpdateOwnInf(Integer userId,Model model){
		OaUser oaUser = oaUserService.doFindOwnInf(userId);
		model.addAttribute("updateId",oaUser.getUserId());
		model.addAttribute("updateAccount",oaUser.getUserAccount());
		model.addAttribute("updateEmail",oaUser.getUserEmail());
		model.addAttribute("updatePhone",oaUser.getUserPhone());
		model.addAttribute("updateName",oaUser.getUserName());
		return "admin/userInf/updateUserInf";
		}

	/**
	 *
	 * @param oaUser
	 * @param
	 * @return
	 * @description 开始修改
	 */
	@RequestMapping(value = "doUpdateInf.action")
	@ResponseBody
	public String doUpdateInf(OaUser oaUser){
		int row= oaUserService.updateOwnInf(oaUser);
		if (row > 0){
		return "success";
		}
		else {
			return "failure";
		}
	}
   //用户修改密码
	@RequestMapping(value = "doEditPwd.action")
	public String doEditPwd(Integer userId,Model model){
		OaUser oaUser = oaUserService.doFindOwnInf(userId);
		if (null!=oaUser) {
			model.addAttribute("oldPassword", oaUser.getUserPassword());
			model.addAttribute("userName", oaUser.getUserName());
			model.addAttribute("userId", oaUser.getUserId());
		}
		return "admin/userInf/updatePwdInf";
	}
	@RequestMapping(value = "doUpdatePwd.action")
	@ResponseBody
	public OaUser doUpdatePwd(OaUser oaUser) {
		int row  = oaUserService.updatePassword(oaUser);
		if (row >0) {
			return oaUser;
		} else {
			return null;
		}
	}
	@RequestMapping(value = "doFindAllUser")
	@ResponseBody
	public List<OaUser> selectAllUser(){
       List<OaUser> oaUsers = oaUserService.selectAllUser();
         return oaUsers;
	}
	}