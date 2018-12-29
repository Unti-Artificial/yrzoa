package com.yrz.oa.core.service;

import com.yrz.oa.core.po.Inform;

import java.util.List;

public interface InformService {
    int updateInform(Inform inform);
    int addInform(Inform inform);
    int deleteInformById(Integer informId);
    List<Inform> getAllInform();
    Inform getInformById(Integer id);
}
