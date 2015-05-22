package cn.com.mobilereal.common.ui;

import java.util.Collections;
import java.util.List;

import cn.com.mobilereal.common.dao.BaseBean;
import cn.com.mobilereal.common.service.BaseCrudService;


@SuppressWarnings("serial")
public class BaseCrudWebAction<T extends BaseBean> extends BaseWebSearchAction {
    /**
     * 编辑页面用的对象
     */
	protected T bean;
	
    /**
     * 过滤页面用的对象
     */
    protected T filter;
	/**
	 * 上传附件用
	 */
	protected Long assetId;
    /**
     * 业务逻辑层对象
     */
	protected BaseCrudService<T> service;
	
	/**
　　　 * <p>Description: 构造方法</p>
	 */
	public BaseCrudWebAction() {
		super();

	}

    @Override
    public void init() {
        super.init();
    }
    
    public void setBean(T bean) {
        this.bean = bean;
    }

    public T getBean() {
        return bean;
    }
    
    @SuppressWarnings("unchecked")
    public List<T> makeSearchList() {
        if (pageBean != null) {
            return (List<T>) pageBean.getList();
        } else {
            return Collections.EMPTY_LIST;
        }
    }
    
    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }

    /**
　　　 * <p>Description: 查询方法，对应页面查询按钮，及画面的初始化查询</p>
     */
    public void search() {
       pageBean = service.searchByExample(this.pageNo, this.pageSize,this.filter);
    }

    /**
　　　 * <p>Description: 保存方法，对应页面保存，提交按钮</p>
     */
	public void save() {
	    service.save(bean);
	}
	
    /**
　　　 * <p>Description: 删除方法，对应页面删除按钮</p>
     */
	public void delete() {
		service.delete(chk);
	}
	
    /**
　　　 * <p>Description: 清空方法，对应页面清空按钮</p>
     */
    public void clear() {
        service.clearAll();
    }
	
    /**
　　　 * <p>Description: 新增方法，对应页面增加按钮</p>
     */
	public void add() {
		this.bean = service.add();
	}

    /**
　　　 * <p>Description: 编辑方法，对应页面编辑按钮</p>
     */
	public void edit() {
		this.bean = service.findById(chk[0]);
	}
	
    /**
　　　 * <p>Description: 查看方法，对应页面查看按钮</p>
     */
    public void view() {
        this.bean = service.findById(chk[0]);
    }
    
    /**
     * 
     * <p>Description: 进入下一步</p>
     */
    public void submitNextStep(){
    
    }
    /**
     * 
     * <p>Description: 进入下一步</p>
     */
    public void nextStep(){
    
    }

}
