package com.yrz.oa.core.service.impl;

import com.yrz.oa.core.dao.WorkLogDao;
import com.yrz.oa.core.po.WorkLog;
import com.yrz.oa.core.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("workLogService")
@Transactional
public class WorkLogServiceImpl implements WorkLogService {
    @Autowired
    private WorkLogDao workLogDao;
    @Override
    public int deleteWorkLog(Integer logId) {
        return workLogDao.deleteWorkLog(logId);
    }

    @Override
    public int updateWorkLog(WorkLog workLog) {
        return workLogDao.updateWorkLog(workLog);
    }

    @Override
    public int addWorkLog(WorkLog workLog) {
        return workLogDao.addWorkLog(workLog);
    }

    @Override
    public List<WorkLog> selectWorkLogListByName(String user) {
        return workLogDao.selectWorkLogListByName(user);
    }
}
