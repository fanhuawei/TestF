package cn.com.mobilereal.common.ui;

import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.PageBean;

@SuppressWarnings("serial")
abstract public class BaseWebSearchAction extends BaseWebAction {

    /**
     * 分页查询结果
     */
    protected PageBean pageBean;
    /**
     * 分页的页号
     */
	protected int pageNo = 1;
    /**
     * 每页的记录数
     */
	protected int pageSize = ConfigInfo.$.getPageSize();
    /**
     * 列表页面做编辑与删除用
     */
	protected Long[] chk; 


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Long[] getChk() {
		return chk;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setChk(Long[] chk) {
		this.chk = chk;
	}

	/**
     * <p>Description: 画面初始化操作</p>
     */
	@Override public void init() {
		search();
	}
	
	/**
	 * <p>Description: 取消操作</p>
	 */
    public void cancel() {

    }
    abstract public void search();
    abstract public void delete();
    abstract public void add();
    abstract public void edit();
    abstract public void view();

}
