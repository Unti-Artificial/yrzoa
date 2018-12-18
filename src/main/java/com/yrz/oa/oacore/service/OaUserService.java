package com.itheima.oacore.service;

import com.itheima.oacore.po.OaUser;

public interface OaUserService {
    OaUser doLogin(String account,String password,String role);
    int doRegister(OaUser oaUser);
}
