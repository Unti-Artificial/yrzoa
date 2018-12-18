package com.itheima.oacore.dao;

import com.itheima.oacore.po.OaUser;
import org.apache.ibatis.annotations.Param;

public interface OaUserDao {
    int doRegister(OaUser oaUser);
    OaUser doLogin(@Param("account")String account,@Param("password")String password,@Param("role")String role);
}
