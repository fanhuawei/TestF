/**
 * ActionTransfer.java
 * Created at 2014年11月12日
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.common.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * <p>ClassName: ActionTransfer</p>
 * <p>Description: 实现此接口的Action可以在Action对象之间传递对象</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年11月12日</p>
 */
@java.lang.annotation.Target(value={ElementType.FIELD})
@java.lang.annotation.Retention(value=RetentionPolicy.RUNTIME)
public @interface ActionTransfer {
    DirectionEnum value() default DirectionEnum.BOTH;
    boolean required() default false;
    MenuEnum menu() default MenuEnum.SYSTEM;
}
