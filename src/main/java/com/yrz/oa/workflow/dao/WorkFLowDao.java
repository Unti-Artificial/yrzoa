package com.yrz.oa.workflow.dao;

import com.yrz.oa.workflow.po.*;

public interface WorkFLowDao {
    Apply selectNotDealWithFirstApply();
    Apply selectNotDealWithSecondApply();
    Apply selectNotDealWithThirdApply();

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
