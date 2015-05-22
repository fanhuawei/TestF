package cn.com.mobilereal.common.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.mobilereal.common.web.ResponseObject;

public interface WebAction {
    public void init();   
    public String makeNextPage();
    public void setMenuEnum(MenuEnum menuEnum);
  	public MenuEnum getMenuEnum(); 
	public String getAction(); 
	public void setAction(String action); 
	public MenuActionEnum[] getActions();
	public MenuActionEnum[] getUserActions();
	public ResponseObject getResult(); 
	public void setResult(ResponseObject result); 
	public HttpServletRequest getRequest(); 
	public HttpServletResponse getResponse(); 
	
}
