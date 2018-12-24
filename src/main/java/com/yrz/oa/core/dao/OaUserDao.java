package com.yrz.oa.core.dao;

import com.yrz.oa.core.po.OaUser;
import org.apache.ibatis.annotations.Param;

public interface OaUserDao {
      OaUser doLogin(@Param("account") String account,
                            @Param("password") String password
     );
     OaUser doFindIns(Integer userId);
     int updateInf(@Param("userPassword") String userPassword);
     int doRegister(OaUser oaUser);
     int updateBasicInf(OaUser oaUser);
}
