package com.yrz.oa.core.service;

import com.yrz.oa.core.po.Inform;

public interface InformService {
    Inform getInformContent(Integer id);
    int updateInform(String content);
    int publishInform(Inform inform);
}
