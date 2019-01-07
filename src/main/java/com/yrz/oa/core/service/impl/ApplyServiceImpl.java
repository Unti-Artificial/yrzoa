package com.yrz.oa.core.service.impl;

import com.yrz.oa.core.dao.ApplyDao;
import com.yrz.oa.core.po.Apply;
import com.yrz.oa.core.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("applyService")
@Transactional
public class ApplyServiceImpl implements ApplyService {
 @Autowired
 private ApplyDao applyDao;
    @Override
    public int startApply(Apply apply) {
        return applyDao.startApply(apply);
    }
}
