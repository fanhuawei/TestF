package cn.com.mobilereal.common.demo;

import cn.com.mobilereal.common.action.MobileAction;
import cn.com.mobilereal.common.action.MobileActionEnum;
import cn.com.mobilereal.common.web.ResponseObject;
import cn.com.mobilereal.common.web.SynchronizedException;

public class BusiExceptionAction implements MobileAction {

	@Override
	public ResponseObject execute(MobileActionEnum actionEnum) {
		throw new SynchronizedException("业务错误");
	}
    @Override
    public void check() {
        
    }
}
