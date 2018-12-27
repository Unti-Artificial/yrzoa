package com.yrz.oa.core.dao;

import com.yrz.oa.core.po.OaUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OaUserDao {
      OaUser doLogin(@Param("account") String account,
                            @Param("password") String password
     );
     OaUser doFindOwnInf(Integer userId);
     int updatePassword(OaUser oaUser);
     int doRegister(OaUser oaUser);
     int updateOwnInf(OaUser oaUser);
     List<OaUser> selectAllUser();
}
