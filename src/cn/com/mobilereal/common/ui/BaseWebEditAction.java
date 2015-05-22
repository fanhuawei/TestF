package cn.com.mobilereal.common.ui;

import cn.com.mobilereal.common.dao.BaseBean;

@SuppressWarnings("serial")
public abstract class BaseWebEditAction<T extends BaseBean> extends BaseWebAction {
	protected T bean;
	protected Long chk;

	public void init(){
	   bean = null;
	   chk = null;
	}
	
    public Long getChk() {
		return chk;
	}

	public void setChk(Long chk) {
		this.chk = chk;
	}

	public void setBean(T bean) {
		this.bean = bean;
	}

	public T getBean(){
	  return bean;
	}
	
    public void save(){
 	}
 	
 	
}
