package com.yrz.oa.core.service;


import com.yrz.oa.core.po.*;

import java.util.List;

public interface WorkFlowService {
    List<Apply> selectNotDealWithFirstApply();
    List<Apply> selectNotDealWithSecondApply();
    List<Apply> selectNotDealWithThirdApply();

    int updateFirstApplyState(Apply apply);
    int firstApprove (FirstApprove firstApprove);
    int PassFirstApprove(FirstResult firstResult);
    int updateSecondApplyState(Apply apply);
    int secondApprove (FirstApprove firstApprove);
    int PassSecondApprove(SecondResult secondResult);
    int updateThirdApplyState(Apply  apply);
    int thirdApprove(ThirdApprove thirdApprove);
    int PassThirdApprove(ThirdResult thirdResult);
    int addResult(Result result);
    int fallFirstApprove(FirstApproveFailure firstApproveFailure);
    int fallSecondApprove(SecondApproveFailure secondApproveFailure);
    int fallThirdApprove(ThirdApproveFailure thirdApproveFailure);
    int addFailure(Failure failure);
}
