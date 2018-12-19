package com.yrz.oa.core.service.impl;

import com.yrz.oa.core.dao.InformDao;
import com.yrz.oa.core.po.Inform;
import com.yrz.oa.core.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("informService")
@Transactional
public class InformServiceImpl implements InformService {
    @Autowired
    private InformDao informDao;

    @Override
    public Inform getInformContent(Integer id) {
        return informDao.getInformContent(id);
    }

    @Override
    public int updateInform(String content) {
        return informDao.updateInform(content);
    }

    @Override
    public int publishInform(Inform inform) {
        return informDao.publishInform(inform);
    }
}
