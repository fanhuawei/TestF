package cn.com.mobilereal.common.action;

import cn.com.mobilereal.common.demo.PingAction;


/**
 * 手机端所有请求及相应的响应的Action类。 
 * 不同的项目需要填写不同的内容。
 */
public enum MobileActionEnum {

   PING("ping","ping测试",PingAction.class);
    

    private String action;
    
    private String comment;
    private Class<? extends MobileAction> actionCls;
    
    public String getAction(){
        return action;
    }
    
    public String getComment() {
        return comment;
    }

    private MobileActionEnum(String action,String comment, Class<? extends MobileAction> cls){
        this.action = action;
        this.comment = comment;
        this.actionCls = cls;
    }   
    
    public Class<? extends MobileAction> getActionCls(){
      return actionCls;
    }
}
