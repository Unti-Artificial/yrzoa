package com.yrz.oa.core.service.impl;
import com.yrz.oa.core.dao.OaUserDao;
import com.yrz.oa.core.po.OaUser;
import com.yrz.oa.core.service.OaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service接口实现类
 */
@Service("oaUserService")
@Transactional
public class OaUserServiceImpl implements OaUserService {
	// 注入UserDao
	@Autowired
	private OaUserDao oaUserDao;
	// 通过账号和密码查询用户
	@Override
	public OaUser doLogin(String account, String password) {
		OaUser oaUser = this.oaUserDao.doLogin(account,password);
		return oaUser;
	}

	@Override
	public OaUser doFindOwnInf(Integer userId) {
		return oaUserDao.doFindOwnInf(userId);
	}

	@Override
	public int doRegister(OaUser oaUser) {
		return oaUserDao.doRegister(oaUser);
	}

	@Override
	public int updateOwnInf(OaUser oaUser) {
		return oaUserDao.updateOwnInf(oaUser);
	}

	@Override
	public int updatePassword(String userPassword,String userName) {
		return oaUserDao.updatePassword(userPassword,userName);
	}
}
