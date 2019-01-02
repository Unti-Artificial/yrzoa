package com.yrz.oa.core.service;

import com.yrz.oa.core.po.WorkLog;

import java.util.List;

public interface WorkLogService {
    int deleteWorkLog(Integer logId);
    int updateWorkLog(WorkLog workLog);
    int addWorkLog(WorkLog workLog);
    List<WorkLog> selectWorkLogListByName(String user);
}
