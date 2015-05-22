package cn.com.mobilereal.common.ui;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.mobilereal.common.util.RedirectUtil;
import cn.com.mobilereal.common.util.ThreadLocalBean;
import cn.com.mobilereal.common.web.ResponseObject;
import cn.com.mobilereal.framework.dbbean.User;

@SuppressWarnings("serial")
public abstract class BaseWebAction extends WebActionWithLog implements Serializable{
    
	private MenuEnum menuEnum;
	private MenuEnum preMenuEnum;
    
	private String action;
	private ResponseObject result;
	
	public BaseWebAction() {
       
    }
    
    /**
     * 父对象的ID，对应查询明细操作
     */
    protected Long pid;   
    /**
     * 父对象，用于子对象的的页面显示将对象的数据。
     */
    protected Object parentBean;
    
    public Object getParentBean() {
        return parentBean;
    }

    public void setParentBean(Object parentBean) {
        this.parentBean = parentBean;
    }
    
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public void ajaxSelect() {

    }

    public void ajaxDiv() {

    }

    public void ajaxFilter() {

    }

    public void ajaxPopup() {

    }
    public HttpServletRequest getRequest(){
       return ThreadLocalBean.getRequest();
    }
    public HttpServletResponse getResponse(){
       return ThreadLocalBean.getResponse();
    }
	
	@Override
	public String makeNextPage() {
		return "/Action/" + getClass().getSimpleName() + ".jsp";
	}	
	
	public ResponseObject getResult() {
		return result;
	}

	public void setResult(ResponseObject result) {
		this.result = result;
	}

	public MenuEnum getPreMenuEnum() {
        return preMenuEnum;
    }

    public void setPreMenuEnum(MenuEnum preMenuEnum) {
        this.preMenuEnum = preMenuEnum;
    }

    public MenuEnum getMenuEnum() {
		return menuEnum;
	}

	public void setMenuEnum(MenuEnum menuEnum) {
		this.menuEnum = menuEnum;
	}
	public String getAction() {
	    if (action==null) return "init";
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * 获得画面上所有的按钮
	 */
	public MenuActionEnum[] getActions(){
		return MenuActionEnum.values();
    }
    
    /**
     * 
     * <p>Description: 在JSP中显示消息</p>
     */
    public void showMsg(String msg){
       setResult(new ResponseObject(0, msg));
    }

	/**
	 * 获得画面上当前用户可见的按钮，用于权限控制
	 */
	@Override
	public MenuActionEnum[] getUserActions() {
		return getActions();
	}
	
	/**
	 * <p>Description: 获得当前登录用户</p>
	 * @return 登录用户
	 */
	protected User getCurrentUser(){
	   return ThreadLocalBean.getUser();
	}

    /**
     * 
     * <p>
     * Description: 跳转到其它功能模块
     * </p>
     * 
     * @param menu 目标功能模块
     */
    protected void sendRedirect(MenuEnum menu) {
        RedirectUtil.redirect(menu.getPrefixUrl());
    }

    /**
     * 
     * <p>
     * Description: 跳转到其它功能模块
     * </p>
     * 
     * @param menu 目标功能模块
     */
    protected void sendRedirect(MenuEnum menu, String param) {
        RedirectUtil.redirect(menu.getPrefixUrl() + "?" + param);
    }
   

}
