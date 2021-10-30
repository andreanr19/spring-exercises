/*
 * Copyright (C) 2019 Fastjrun, Inc. All Rights Reserved.
 */
package Learning.learnmvc.executor;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fastjrun.executor.BaseSimpleJobExecutor;
import Learning.learnmvc.service.CoreUserService;

@Component("unlockUserPwdExecutor")
public class UnlockUserPwdExecutor extends BaseSimpleJobExecutor {
    @Autowired
    private CoreUserService coreUserService;

    @Override
    public void execute() {
        this.coreUserService.unlockUserPwd(new Date());
    }
}
