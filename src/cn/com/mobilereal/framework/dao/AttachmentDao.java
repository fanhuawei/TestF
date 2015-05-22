/**
 * AttachmentDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.framework.dbbean.Attachment;
import cn.com.mobilereal.framework.dbbean.IDaoConst;


/**
 * <p>ClassName: AttachmentDao</p>
 * <p>Description: 附件表Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class AttachmentDao extends GenericDao<Attachment> {

    /**
     * <p>Description: 构造方法</p>
     */
    public AttachmentDao() {
        super(TableEnum.TS_ATTACHMENT, Attachment.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_ATTACHMENT_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_ATTACHMENT_U;
    }
}

