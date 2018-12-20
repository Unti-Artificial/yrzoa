package com.yrz.oa.core.dao;

import com.yrz.oa.core.po.OaUser;
import org.apache.ibatis.annotations.Param;

public interface OaUserDao {
      OaUser doLogin(@Param("account") String account,
                            @Param("password") String password,
                            @Param("role") String role
     );
     OaUser doFindIns(Integer id);
     int updateInf(OaUser oaUser);
     int doRegister(OaUser oaUser);
     int updateBasicInf(OaUser oaUser);
}
