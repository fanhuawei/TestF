/**
 * DeviceService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.PageBean;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.framework.dbbean.Device;

/**
 * 
 * <p>ClassName: DeviceService</p>
 * <p>Description: PAD设备管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class DeviceService extends BaseCrudService<Device> {
    /**
     * 实例
     */
    public static final DeviceService I = ServiceFactory.makeService(DeviceService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public DeviceService() {
       super(Device.I, Device.class);
    }

    @Override
    public PageBean searchByExample(int pageNo, int pageSize, Device filter) {
        StringBuilder sb = new StringBuilder("WHERE DELETE_MARK=?");
        List<Object> list = new ArrayList<Object>();
        list.add(ConstUtil.FLAG.NO);
        if (filter != null) {
            if (!StringUtil.isEmpty(filter.getKeyword())) {
                sb.append(" AND (NAME LIKE ? OR SN LIKE ?)");
                list.add("%" + filter.getKeyword() + "%");
                list.add("%" + filter.getKeyword() + "%");
            }
        }
        sb.append(" ORDER BY CONVERT(NAME USING gbk)");
        return Device.I.doPageQuery(pageNo, pageSize, sb.toString(), list.toArray());
    }     
}
