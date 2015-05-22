package cn.com.mobilereal.common.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.DateUtil;
import cn.com.mobilereal.common.util.JDBCUtil;
import cn.com.mobilereal.common.util.PKUtil;
import cn.com.mobilereal.common.util.PageBean;
import cn.com.mobilereal.common.util.SQLUtil;
import cn.com.mobilereal.common.util.ThreadLocalBean;

@SuppressWarnings("serial")
abstract public class GenericDao<T extends BaseBean> implements Serializable{

	private TableEnum table;
    private Class<T> cls;

	public GenericDao(TableEnum table,Class<T> cls) {
		this.table = table;
		this.cls = cls;
	}

	public int insert(T t) {
	    t.setUpdateTime(DateUtil.getSystemTimestamp());
        t.setCreateTime(t.getUpdateTime());
        if (ThreadLocalBean.getUser() != null){
          t.setCreateBy(ThreadLocalBean.getUser().getId());
        }
        t.setUpdateBy(t.getCreateBy());
        t.setDeleteMark(ConstUtil.FLAG.NO);
        if (t.getId() == null) {
            t.setId(PKUtil.$.getPK(table));
        }
        String sql = makeInsert();
        Object[] argus =t.makeRealArgu(true);
        return JDBCUtil.doUpdate(sql, argus);
	}
	
	public int update(T t) {
	    t.setUpdateTime(DateUtil.getSystemTimestamp());
        if (ThreadLocalBean.getUser() != null){
            t.setUpdateBy(ThreadLocalBean.getUser().getId());
        }
        String sql = makeUpdate();
        Object[] argus = t.makeRealArgu(false);
        return JDBCUtil.doUpdate(sql, argus);
    }

	public int save(T t) {
		if (t.getId() == null) {
			return insert(t);
		} else {			
			int ret = update(t);
			if (ret == 0){
			    return insert(t);
			}
			return ret;
		}		
	}
	
	abstract protected String makeInsert();
	abstract protected String makeUpdate();
	
	public int deleteByPk(Long... pk) {
	    StringBuilder sb = new StringBuilder("DELETE FROM ");
	    sb.append(table.getTableName()).append(" WHERE");
	    for(Long i:pk){
	      sb.append(" ID = ").append(i).append(" OR");
	    }
	    sb.setLength(sb.length()-3);
		return JDBCUtil.doUpdate(sb.toString());
	}
	
	public int deleteAll(){
	    return JDBCUtil.doUpdate("DELETE FROM " + table.getTableName());
	}
	
	public int deleteByWhere(String where,Object... argu) {
	    StringBuilder sb = new StringBuilder("DELETE FROM ");
	    if (where == null || where.trim().length()==0){
	       sb.append(table.getTableName());
	    }else{
	        sb.append(table.getTableName()).append(" ").append(where);
	    }
		return JDBCUtil.doUpdate(sb.toString(),argu);
	}
	
	public int countByWhere(String where,Object... argu) {
        StringBuilder sb = new StringBuilder("SELECT COUNT(*) FROM ");
        if (where == null || where.trim().length()==0){
           sb.append(table.getTableName());
        }else{
            sb.append(table.getTableName()).append(" A ").append(where);
        }
        Number num = (Number)JDBCUtil.doQuerySingleValue(sb.toString(),argu);
        return num.intValue();
    }

	public T findById(Long pk) {
		String sql = "SELECT * FROM " + table.getTableName() + " WHERE ID = ?";
		List<T> ret = JDBCUtil.doQueryBeanList(cls, sql,  pk);
		if (ret.isEmpty()) return null;
		return ret.get(0);
	}
	
    public Map<Long,T> findMapByIds(Long... id) {
        Map<Long,T> retMap = new HashMap<Long,T>();
        List<T> list = findByIds(id);
        for (T t : list) {
            retMap.put(t.getId(), t);
        }
        return retMap;
    }
    
    public List<T> findByIds(Long... id) {
        if (id == null || id.length == 0){
           return new ArrayList<T>();
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ").append(table.getTableName()).append(" WHERE ");
        for (int i = 0; i < id.length; i++) {
            sql.append("ID = ").append(id[i]).append(" OR ");
        }
        sql.setLength(sql.length()-3);        
        return JDBCUtil.doQueryBeanList(cls, sql.toString());
    }
	public T lockById(Long pk) {
		String sql = "SELECT * FROM " + table.getTableName() + " WHERE ID = ? FOR UPDATE";
		List<T> ret = JDBCUtil.doQueryBeanList(cls, sql,  pk);
		if (ret.isEmpty()) return null;
		return ret.get(0);
	}
	
	public List<T> findByWhere(String where, Object... argu) {
		String sql = "SELECT A.* FROM " + table.getTableName() + " A";
		if (where!=null && where.length()>0){
		  sql = sql + " " + where;
		}
		return JDBCUtil.doQueryBeanList(cls, sql, argu);
	}
	
	public T findOneByWhere(String where, Object... argu) {
        List<T> t= findByWhere(where, argu);
        int size = t.size();
        if (size==1){
          return t.get(0);
        }else if (size>1){
          return t.get(0);
        }else{
          return null;
        }
    }
	
	   public List<T> findDistinctByWhere(String where, Object... argu) {
	        String sql = "SELECT DISTINCT A.* FROM " + table.getTableName() + " A";
	        if (where!=null && where.length()>0){
	          sql = sql + " " + where;
	        }
	        return JDBCUtil.doQueryBeanList(cls, sql, argu);
	    }


	public PageBean doPageQuery(int pageNo , int pageSize) {
        String sql = "SELECT A.* FROM " + table.getTableName() + " A WHERE A.DELETE_MARK=? ORDER BY A.ID";
        return JDBCUtil.doPageBeanQuery(cls, pageNo, pageSize, sql, ConstUtil.FLAG.NO);
    }
    
    public PageBean doPageQuery(int pageNo, int pageSize, String where, Object... argu) {
        String sql = "SELECT A.* FROM " + table.getTableName() + " A";
        if (where!=null && where.length()>0){
          sql = sql + " " + where;
        }
        return JDBCUtil.doPageBeanQuery(cls, pageNo, pageSize, sql, argu);
    }
    
   public PageBean doPageQueryByExample(int pageNo, int pageSize, T filter){
       if (filter == null) {
           return doPageQuery(pageNo, pageSize);
         }
       SQLUtil util = SQLUtil.build(filter);
       return doPageQuery(pageNo, pageSize,util.getSql(), util.getArgu().toArray());
   }
   
   public List<T> findByExample(T filter){
       if (filter == null) {
         return findByWhere("");
       }
       SQLUtil util = SQLUtil.build(filter);
       return findByWhere(util.getSql(), util.getArgu().toArray());
   }
    
	public int updateByWhere(String where, Object... argu) {
		String sql = "UPDATE " + table.getTableName();
		if (where!=null && where.length()>0){
		  sql = sql + " " + where;
		}
		return JDBCUtil.doUpdate(sql, argu);
	}
	
	public int markDelete(Long... pks) {
		StringBuilder sb = new StringBuilder("UPDATE ");
	    sb.append(table.getTableName()).append(" SET DELETE_MARK=?").append(" WHERE");
	    for(Long i:pks){
	      sb.append(" ID = ").append(i).append(" OR");
	    }
	    sb.setLength(sb.length()-3);
		return JDBCUtil.doUpdate(sb.toString(),ConstUtil.FLAG.YES);
	}
	
    protected String like(String condi) {
        return "%" + condi + "%";
    }

    protected SQLUtil makeSQLUtil(){
       return new SQLUtil("WHERE 1=1");
    }
}
