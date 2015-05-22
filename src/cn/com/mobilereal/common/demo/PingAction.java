package cn.com.mobilereal.common.demo;

import java.util.Map;

import cn.com.mobilereal.common.action.HttpParameterAnnotation;
import cn.com.mobilereal.common.action.MobileAction;
import cn.com.mobilereal.common.action.MobileActionEnum;
import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.XmlUtil;
import cn.com.mobilereal.common.web.ResponseObject;


@HttpParameterAnnotation
public class PingAction implements MobileAction {
    
    /**
     * flag = w或者f，分别是白皮书和试车项目程序
     */
    private String flag= "F" ;
    
	public ResponseObject execute(MobileActionEnum actionEnum) {
	    String path = ConfigInfo.$.getAssetPath() + "app/";
	    String file = path + "FBS.ipa";
	    if ("W".equalsIgnoreCase(flag)){
	      file = path + "WhitePaper.ipa";
	    }
        Map<String, String> info = XmlUtil.getAppInfo(file);
        if (info.get("VERSION") == null){
            return new ResponseObject("1.0"); 
        }else{
            return new ResponseObject(info.get("VERSION")); 
        }                  
	}

    @Override
    public void check() {
        
    }

	
	

}
