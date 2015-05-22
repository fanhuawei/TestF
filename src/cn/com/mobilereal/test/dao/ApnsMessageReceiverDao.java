/**
 * ApnsMessageReceiverDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.ApnsMessageReceiver;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: ApnsMessageReceiverDao</p>
 * <p>Description: 推送消息接受人Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class ApnsMessageReceiverDao extends GenericDao<ApnsMessageReceiver> {

    /**
     * <p>Description: 构造方法</p>
     */
    public ApnsMessageReceiverDao() {
        super(TableEnum.TS_APNS_MESSAGE_RECEIVER, ApnsMessageReceiver.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_APNS_MESSAGE_RECEIVER_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_APNS_MESSAGE_RECEIVER_U;
    }
}

