/**
 * UserDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import java.util.List;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.User;

/**
 * <p>ClassName: UserDao</p>
 * <p>Description: 系统用户Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class UserDao extends GenericDao<User> {

    /**
     * <p>Description: 构造方法</p>
     */
    public UserDao() {
        super(TableEnum.TS_USER, User.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_USER_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_USER_U;
    }
    
    /**
     * <p>
     * Description: 根据角色id获取用户列表
     * </p>
     * 
     * @param rid 角色id
     * @return 用户列表
     */
    public List<User> getUserByRole(Long rid) {
        final String WH = "JOIN TR_USER_ROLE B ON A.ID = B.USER_ID WHERE A.DELETE_MARK=? "
                + "AND B.DELETE_MARK=? AND B.ROLE_ID=? ORDER BY A.NAME";
        return User.I.findByWhere(WH, ConstUtil.FLAG.NO, ConstUtil.FLAG.NO, rid);
    }

    /**
     * <p>
     * Description: 根据角色id获取非角色用户列表
     * </p>
     * 
     * @param rid 角色id
     * @return 用户列表
     */
    public List<User> getNotUserByRole(Long rid) {
        final String WH = "WHERE A.DELETE_MARK=? AND A.ID NOT IN (SELECT USER_ID FROM TR_USER_ROLE "
                + "WHERE ROLE_ID=? AND DELETE_MARK=?) ORDER BY A.NAME";
        return User.I.findByWhere(WH, ConstUtil.FLAG.NO, rid, ConstUtil.FLAG.NO);
    }
    
    /**
     * <p>
     * Description: 根据用户工号获取用户
     * </p>
     * 
     * @param code 工号
     * @return 用户
     */
    public User getUserByCode(String code) {
        final String WH = "WHERE A.DELETE_MARK=? AND A.CODE=?";
        final List<User> LIST = User.I.findByWhere(WH, ConstUtil.FLAG.NO, code);
        if (LIST.size() > 0) {
            return LIST.get(0);
        } else {
            return null;
        }
    }
}

