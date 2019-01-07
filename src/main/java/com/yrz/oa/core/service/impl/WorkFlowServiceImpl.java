package com.yrz.oa.core.service.impl;

import com.yrz.oa.core.po.*;
import com.yrz.oa.core.dao.WorkFLowDao;
import com.yrz.oa.core.service.WorkFlowService;
import com.yrz.oa.core.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("workFlowService")
@Transactional
public class WorkFlowServiceImpl implements WorkFlowService {
    @Autowired
    private WorkFLowDao workFLowDao;
    @Override
    public List<Apply> selectNotDealWithFirstApply() {
        return workFLowDao.selectNotDealWithFirstApply();
    }

    @Override
    public  List<Apply> selectNotDealWithSecondApply() {
        return workFLowDao.selectNotDealWithSecondApply();
    }

    @Override
    public List<Apply> selectNotDealWithThirdApply() {
        return workFLowDao.selectNotDealWithThirdApply();
    }

    @Override
    public int updateFirstApplyState(Apply apply) {
        return workFLowDao.updateFirstApplyState(apply);
    }

    @Override
    public int firstApprove(FirstApprove firstApprove) {
        return workFLowDao.firstApprove(firstApprove);
    }

    @Override
    public int PassFirstApprove(FirstResult firstResult) {
        return workFLowDao.PassFirstApprove(firstResult);
    }

    @Override
    public int updateSecondApplyState(Apply apply) {
        return workFLowDao.updateSecondApplyState(apply);
    }

    @Override
    public int secondApprove(FirstApprove firstApprove) {
        return workFLowDao.secondApprove(firstApprove);
    }

    @Override
    public int PassSecondApprove(SecondResult secondResult) {
        return workFLowDao.PassSecondApprove(secondResult);
    }

    @Override
    public int updateThirdApplyState(Apply apply) {
        return workFLowDao.updateThirdApplyState(apply);
    }

    @Override
    public int thirdApprove(ThirdApprove thirdApprove) {
        return workFLowDao.thirdApprove(thirdApprove);
    }

    @Override
    public int PassThirdApprove(ThirdResult thirdResult) {
        return workFLowDao.PassThirdApprove(thirdResult);
    }

    @Override
    public int addResult(Result result) {
        return workFLowDao.addResult(result);
    }

    @Override
    public int fallFirstApprove(FirstApproveFailure firstApproveFailure) {
        return workFLowDao.fallFirstApprove(firstApproveFailure);
    }

    @Override
    public int fallSecondApprove(SecondApproveFailure secondApproveFailure) {
        return workFLowDao.fallSecondApprove(secondApproveFailure);
    }

    @Override
    public int fallThirdApprove(ThirdApproveFailure thirdApproveFailure) {
        return workFLowDao.fallThirdApprove(thirdApproveFailure);
    }

    @Override
    public int addFailure(Failure failure) {
        return workFLowDao.addFailure(failure);
    }
}
