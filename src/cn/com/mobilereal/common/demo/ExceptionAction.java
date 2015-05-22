package cn.com.mobilereal.common.demo;

import cn.com.mobilereal.common.action.MobileAction;
import cn.com.mobilereal.common.action.MobileActionEnum;
import cn.com.mobilereal.common.web.ResponseObject;

public class ExceptionAction implements MobileAction {

	@Override
	public ResponseObject execute(MobileActionEnum actionEnum) {
		throw new RuntimeException("系统错误");
	}
    @Override
    public void check() {
        
    }
}
