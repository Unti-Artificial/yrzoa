package com.yrz.oa.core.dao;

import com.yrz.oa.core.po.OaUser;
import org.apache.ibatis.annotations.Param;

public interface OaUserDao {
      OaUser doLogin(@Param("account") String account,
                            @Param("password") String password
     );
     OaUser doFindOwnInf(Integer userId);
     int updatePassword(@Param("userPassword") String userPassword);
     int doRegister(OaUser oaUser);
     int updateOwnInf(OaUser oaUser);
}
