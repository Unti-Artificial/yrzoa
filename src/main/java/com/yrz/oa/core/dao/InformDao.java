package com.yrz.oa.core.dao;

import com.yrz.oa.core.po.Inform;

import java.util.List;

public interface InformDao {
    int updateInform(Inform inform);
    int addInform(Inform inform);
    int deleteInformById(Integer informId);
    List<Inform> getAllInform();
    Inform getInformById(Integer id);
}
