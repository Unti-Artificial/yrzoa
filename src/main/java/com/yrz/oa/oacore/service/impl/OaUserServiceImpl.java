package com.itheima.oacore.service.impl;

import com.itheima.oacore.dao.OaUserDao;
import com.itheima.oacore.po.OaUser;
import com.itheima.oacore.service.OaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("oaUserService")
@Transactional
public class OaUserServiceImpl implements OaUserService {
    @Autowired
    private OaUserDao oaUserDao;
    @Override
    public OaUser doLogin(String account, String password,String role) {
        return oaUserDao.doLogin(account,password,role);
    }

    @Override
    public int doRegister(OaUser oaUser) {
        return oaUserDao.doRegister(oaUser);
    }
}
