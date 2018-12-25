package com.yrz.oa.core.service.impl;

import com.yrz.oa.core.dao.ClockDao;
import com.yrz.oa.core.po.*;
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
    public int ClockOver(ClockOver clockOver) {
        return clockDao.ClockOver(clockOver);
    }

    @Override
    public int ClockInTime(ClockTime clockTime) {
        return clockDao.ClockInTime(clockTime);
    }

    @Override
    public int ClockOverTime(ClockOverTime clockOverTime) {
        return clockDao.ClockOverTime(clockOverTime);
    }

    @Override
    public int ClockToday(ClockToday clockToday) {
        return clockDao.ClockToday(clockToday);
    }

    @Override
    public Integer selectTotalByNameAndDate(String username, String date) {
        return clockDao.selectTotalByNameAndDate(username,date);
    }

    @Override
    public Integer selectTotalOverByNameAndDate(String username, String date) {
        return clockDao.selectTotalOverByNameAndDate(username,date);
    }

    @Override
    public Integer selectDegree(String present,String userName) {
        return clockDao.selectDegree(present,userName);
    }

    @Override
    public Integer selectOverDegree(String present, String userName) {
        return clockDao.selectOverDegree(present,userName);
    }

    @Override
    public Integer selectIfOrNotClock(String today) {
        return clockDao.selectIfOrNotClock(today);
    }

}
