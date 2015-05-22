/**
 * AttachmentService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.Attachment;


/**
 * 
 * <p>ClassName: AttachmentService</p>
 * <p>Description: 附件表管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class AttachmentService extends BaseCrudService<Attachment> {
    /**
     * 实例
     */
    public static final AttachmentService I = ServiceFactory.makeService(AttachmentService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public AttachmentService() {
       super(Attachment.I, Attachment.class);
    }
}
