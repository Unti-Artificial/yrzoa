package com.yrz.oa.core.dao;

import com.yrz.oa.core.po.Inform;

public interface InformDao {
    Inform getInformContent(Integer id);
    int updateInform(String content);
    int publishInform(Inform inform);
}
