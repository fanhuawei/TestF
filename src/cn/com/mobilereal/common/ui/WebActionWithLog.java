package cn.com.mobilereal.common.ui;

import org.apache.log4j.Logger;


public abstract class WebActionWithLog implements WebAction {

    protected Logger log;
 	
    public WebActionWithLog() {
        this.log = Logger.getLogger(getClass());
    }

}
