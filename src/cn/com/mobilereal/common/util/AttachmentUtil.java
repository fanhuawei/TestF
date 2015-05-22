/**
 * AttachmentUtil.java
 * Created at 2014-08-12
 * Created by Fanhuawei
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package cn.com.mobilereal.common.util;

import cn.com.mobilereal.framework.dbbean.Attachment;

/**
 * <p>ClassName: AttachmentUtil</p>
 * <p>Description: 附件操作工具类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年8月12日</p>
 */
public class AttachmentUtil {


   /**
    * <p>Description: 附件的全路径</p>
    * @param atta 附件
    * @return 附件的全路径
    */
    public static String makeAttachmentPath(Attachment atta) {
        String file = atta.getStorePath();
        if (atta.getStorePath().startsWith("/asset")) {
            file = ConfigInfo.$.getContextRealPath() + atta.getStorePath();
        }
        return file;
    }
}
