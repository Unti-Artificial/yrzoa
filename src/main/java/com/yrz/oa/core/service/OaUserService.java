package com.yrz.oa.core.service;

import com.yrz.oa.core.po.OaUser;

/**
 * 用户Service层接口
 */
public interface OaUserService {
	// 通过账号和密码查询用户
	public OaUser doLogin(String account, String password,String role);
	OaUser doFindIns(String username);
	int updateInf(OaUser oaUser);
	int doRegister(OaUser oaUser);
	int updateBasicInf(OaUser oaUser);
}
