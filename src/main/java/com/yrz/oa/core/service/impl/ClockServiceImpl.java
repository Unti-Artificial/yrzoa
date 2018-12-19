package com.yrz.oa.core.service.impl;

import com.yrz.oa.core.dao.ClockDao;
import com.yrz.oa.core.po.Clock;
import com.yrz.oa.core.po.ClockTime;
import com.yrz.oa.core.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("clockService")
@Transactional
public class ClockServiceImpl implements ClockService {
  @Autowired
  private ClockDao clockDao;

    @Override
    public int ClockIn(Clock clock) {
        return clockDao.ClockIn(clock);
    }

    @Override
    public int ClockInTime(ClockTime clockTime) {
        return clockDao.ClockInTime(clockTime);
    }

    @Override
    public Integer selectTotalByNameAndDate(String username, String date) {
        return clockDao.selectTotalByNameAndDate(username,date);
    }

    @Override
    public Integer selectDegree(String present,String username) {
        return clockDao.selectDegree(present,username);
    }

}
