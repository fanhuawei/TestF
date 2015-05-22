/**
 * WorkReportDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.WorkReport;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: WorkReportDao</p>
 * <p>Description: 工单报告Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkReportDao extends GenericDao<WorkReport> {

    /**
     * <p>Description: 构造方法</p>
     */
    public WorkReportDao() {
        super(TableEnum.TT_WORK_REPORT, WorkReport.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TT_WORK_REPORT_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TT_WORK_REPORT_U;
    }
}

