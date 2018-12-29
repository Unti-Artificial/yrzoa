package com.yrz.oa.core.service.impl;

import com.yrz.oa.core.dao.InformDao;
import com.yrz.oa.core.po.Inform;
import com.yrz.oa.core.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("informService")
@Transactional
public class InformServiceImpl implements InformService {
    @Autowired
    private InformDao informDao;

    @Override
    public int updateInform(Inform inform) {
        return informDao.updateInform(inform);
    }

    @Override
    public int addInform(Inform inform) {
        return informDao.addInform(inform);
    }

    @Override
    public int deleteInformById(Integer informId) {
        return informDao.deleteInformById(informId);
    }

    @Override
    public List<Inform> getAllInform() {
        return informDao.getAllInform();
    }

    @Override
    public Inform getInformById(Integer id) {
        return informDao.getInformById(id);
    }
}
