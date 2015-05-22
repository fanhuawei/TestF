package cn.com.mobilereal.common.action;

import cn.com.mobilereal.common.web.ResponseObject;

/**
 * 手机与后台Web交互的Action基类
 * 一个action对象可以对应多个不同的请求。也可以仅仅对应一个请求。
 * 多个请求时可以通过execute方法的参数来判断： 如下所示：
 * switch (actionEnum) {
	case Demo:
		
		break;
    case List:
		
		break;
	default:
		break;
	}
 * @author Fanhuawei
 *
 */
public interface MobileAction {
    
    /**
     * 
     * <p>Description: 响应Pad端的请求</p>
     * @param actionEnum  Pad端的请求
     * @return 返回给Pad端的对象
     */
    ResponseObject execute(MobileActionEnum actionEnum);
    
    /**
     * 
     * <p>Description: 对上传参数作权限及其它方面的检查</p>
     */
    void check();
    
}
