package com.yrz.oa.core.service;

import com.yrz.oa.core.po.OaUser;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface OaUserService {
	// 通过账号和密码查询用户
	public OaUser doLogin(String account, String password);
	OaUser doFindOwnInf(Integer userId);
	int doRegister(OaUser oaUser);
	int updateOwnInf(OaUser oaUser);
	int updatePassword(OaUser oaUser);
	List<OaUser> selectAllUser();
}
