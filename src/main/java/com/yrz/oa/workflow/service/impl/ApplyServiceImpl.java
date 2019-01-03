package com.yrz.oa.workflow.service.impl;

import com.yrz.oa.workflow.dao.ApplyDao;
import com.yrz.oa.workflow.po.Apply;
import com.yrz.oa.workflow.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("applyService")
@Transactional
public class ApplyServiceImpl implements ApplyService {
 @Autowired
 private ApplyDao applyDao;
    @Override
    public int StartApply(Apply apply) {
        return applyDao.StartApply(apply);
    }
}
