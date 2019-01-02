package com.yrz.oa.core.dao;

import com.yrz.oa.core.po.WorkLog;

import java.util.List;

public interface WorkLogDao {
    int deleteWorkLog(Integer logId);
    int updateWorkLog(WorkLog workLog);
    int addWorkLog(WorkLog workLog);
    List<WorkLog> selectWorkLogListByName(String user);
}
