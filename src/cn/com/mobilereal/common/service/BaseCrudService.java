package cn.com.mobilereal.common.service;

import java.util.List;
import java.util.Map;

import cn.com.mobilereal.common.dao.BaseBean;
import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.PageBean;

@SuppressWarnings("serial")
public abstract class BaseCrudService<T extends BaseBean> extends BaseService implements CrudService<T> {

    protected GenericDao<T> dao;
    protected Class<T> cls;
    
    public BaseCrudService(GenericDao<T> dao, Class<T> cls) {
        this.dao = dao;
        this.cls = cls;
    }

    @Override
    public void save(T t) {
        dao.save(t);
    }

    @Override
    public T add() {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);           
        }
    }

    @Override
    public T findById(Long id) {
        return dao.findById(id);
    }
    
    @Override
    public List<T> findByIds(Long... id) {
        return dao.findByIds(id);
    }
    
    @Override
    public Map<Long,T> findMapByIds(Long... id) {
        return dao.findMapByIds(id);
    }

    @Override
    public PageBean search(int pageNo, int pageSize, Object... argu) {
        return dao.doPageQuery(pageNo, pageSize);
    }
    
    @Override
    public PageBean searchByWhere(int pageNo, int pageSize,String where, Object... argu) {
        return dao.doPageQuery(pageNo, pageSize,where,argu);
    }
    
    @Override
    public PageBean searchByExample(int pageNo, int pageSize, T filter) {
        return dao.doPageQueryByExample(pageNo, pageSize, filter);
    }

    @Override
    public int delete(Long... id) {
        return dao.markDelete(id);
    }
    
    @Override
    public int clearAll() {
        return dao.deleteAll();
    }
    @Override
    public List<T> findByWhere(String wh, Object... argu) {
        return dao.findByWhere(wh,argu);
    }    
    @Override
    public int countByWhere(String wh, Object... argu) {
        return dao.countByWhere(wh,argu);
    }
    @Override
    public int updateByWhere(String wh, Object... argu) {
        return dao.updateByWhere(wh,argu);
    }
    @Override
    public int deleteByWhere(String wh, Object... argu) {
        return dao.deleteByWhere(wh,argu);
    }
    @Override
    public T findOneByWhere(String wh, Object... argu) {
       return dao.findOneByWhere(wh,argu);        
    }

    @Override
    public List<T> findAll() {
        return dao.findByWhere("WHERE DELETE_MARK=? ORDER BY ID",ConstUtil.FLAG.NO);
    }
}
