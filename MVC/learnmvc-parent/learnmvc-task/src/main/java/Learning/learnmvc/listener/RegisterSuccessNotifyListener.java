/*
 * Copyright (C) 2019 Fastjrun, Inc. All Rights Reserved.
 */
package Learning.learnmvc.listener;

import com.fastjrun.listener.BaseListener;
import Learning.learnmvc.entity.User;

public class RegisterSuccessNotifyListener extends BaseListener {
    public void processUser(User user) {
        log.info(" user :" + user);
    }
}

