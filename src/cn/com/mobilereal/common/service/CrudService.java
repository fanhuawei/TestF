package cn.com.mobilereal.common.service;

import java.util.List;
import java.util.Map;

import cn.com.mobilereal.common.dao.BaseBean;
import cn.com.mobilereal.common.util.PageBean;

public interface CrudService<T extends BaseBean> extends Service {

    /**
     * 
     * <p>
     * Description: 数据库的插入和更新操作
     * </p>
     * 
     * @param t 数据对象
     */
    void save(T t);

    /**
     * 
     * <p>
     * Description: 增加操作
     * </p>
     * 
     * @return 数据对象
     */
    T add();

    /**
     * 
     * <p>
     * Description: 根据主键查询单条数据
     * </p>
     * 
     * @param id 主键
     * @return 数据对象
     */
    T findById(Long id);

    /**
     * 
     * <p>
     * Description: 根据主键查询多条数据
     * </p>
     * 
     * @param id 多个主键
     * @return 数据对象
     */
    List<T> findByIds(Long... id);

    /**
     * 
     * <p>
     * Description: 根据主键查询多条数据
     * </p>
     * 
     * @param id 多个主键
     * @return 数据对象Map
     */    
    Map<Long,T> findMapByIds(Long... id);

    /**
     * 
     * <p>
     * Description: 分页查询
     * </p>
     * 
     * @param pageNo 页号 从1开始
     * @param pageSize 一页记录数
     * @param argu 查询条件
     * @return 查询结果
     */
    PageBean search(int pageNo, int pageSize, Object... argu);

    /**
     * 
     * <p>
     * Description: 分页查询
     * </p>
     * 
     * @param pageNo 页号 从1开始
     * @param pageSize 一页记录数
     * @param filter 查询条件
     * @return 查询结果
     */
    PageBean searchByExample(int pageNo, int pageSize, T filter);

    /**
     * 
     * <p>
     * Description: 分页查询
     * </p>
     * 
     * @param pageNo 页号 从1开始
     * @param pageSize 一页记录数
     * @param sql 查询条件
     * @param argu 查询条件
     * @return 查询结果
     */
    PageBean searchByWhere(int pageNo, int pageSize, String sql, Object... argu);

    /**
     * 
     * <p>
     * Description: 根据主键做删除
     * </p>
     * 
     * @param id 主键
     * @return 数据对象的数量
     */
    int delete(Long... id);

    /**
     * 
     * <p>
     * Description: 删除所有数据
     * </p>
     * 
     * @return 数据对象的数量
     */
     int clearAll();
    /**
     * 
     * <p>
     * Description: 查询
     * </p>
     * 
     * @param sql 查询语句
     * @param argu 查询条件
     * @return 查询结果
     */
    List<T> findByWhere(String sql, Object... argu);

    /**
     * 
     * <p>
     * Description: 更新
     * </p>
     * 
     * @param sql 更新语句
     * @param argu 更新条件
     * @return 更新的记录数
     */
    int updateByWhere(String sql, Object... argu);
    
    /**
     * 
     * <p>
     * Description: 统计数据
     * </p>
     * 
     * @param sql 统计语句
     * @param argu 统计条件
     * @return 统计数据
     */
    int countByWhere(String sql, Object... argu);

    /**
     * 
     * <p>
     * Description: 删除
     * </p>
     * 
     * @param sql 删除语句
     * @param argu 删除条件
     * @return 删除记录数
     */
    int deleteByWhere(String sql, Object... argu);

    /**
     * 
     * <p>
     * Description: 查询
     * </p>
     * 
     * @param sql 查询语句
     * @param argu 查询条件
     * @return 查询结果
     */
    T findOneByWhere(String sql, Object... argu);

    /**
     * 
     * <p>
     * Description: 查询所有数据
     * </p>
     * 
     * @return 数据对象列表
     */
    List<T> findAll();
}
