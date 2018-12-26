package com.yrz.oa.core.service;

import com.yrz.oa.core.po.OaUser;

/**
 * 用户Service层接口
 */
public interface OaUserService {
	// 通过账号和密码查询用户
	public OaUser doLogin(String account, String password);
	OaUser doFindOwnInf(Integer userId);
	int doRegister(OaUser oaUser);
	int updateOwnInf(OaUser oaUser);
	int updatePassword(String userPassword);
}
