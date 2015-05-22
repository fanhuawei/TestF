/**
 * SQLUtil.java
 * Created at 2014年9月27日
 * Created by Fanhuawei
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package cn.com.mobilereal.common.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.dao.BaseBean;

/**
 * <p>
 * ClassName: SQLUtil
 * </p>
 * <p>
 * Description: TODO
 * </p>
 * <p>
 * Author: Fanhuawei
 * </p>
 * <p>
 * Date: 2014年9月27日
 * </p>
 */
public class SQLUtil {
    private StringBuilder sql = new StringBuilder();
    private List<Object> argu = new ArrayList<Object>();

    public static String makeQuestionMark(int cnt){
      StringBuffer sb = new StringBuffer();
      for (int i=0;i<cnt;i++){
         sb.append("?,");
      }
      sb.setLength(sb.length()-1);
      return sb.toString();
    }

    private static String makeColumnName(String fname) {
        char[] chArr = fname.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] >= 'A' && chArr[i] <= 'Z') {
                sb.append("_");
            }
            sb.append(chArr[i]);
        }
        return sb.toString().toUpperCase();
    }
    public static SQLUtil start(String sql,Object... argus) {
      return new SQLUtil(sql,argus);
    }
    public static SQLUtil start() {
        return new SQLUtil();
    }
    public static <T extends BaseBean> SQLUtil build(T filter) {
        SQLUtil util = new SQLUtil("WHERE 1=1");
        Field[] fs = filter.getClass().getDeclaredFields();
        for (Field item : fs) {
            if (item.getType() == String.class || item.getType() == BigDecimal.class
                    || item.getType() == Long.class  || item.getType() == Timestamp.class) {
                if (!item.isAccessible()) {
                    item.setAccessible(true);
                }
                try {
                    util.eq(makeColumnName(item.getName()), item.get(filter));
                } catch (IllegalArgumentException e) {

                } catch (IllegalAccessException e) {

                }
            }
        }
        util.sql.append(" ORDER BY ID DESC");
        return util;
    }

    public SQLUtil() {
    }

    public SQLUtil(String ss, Object... argus) {
        sql.append(ss);
        for (Object item : argus) {
            argu.add(item);
        }
    }
    
    public SQLUtil multiCond(String ss,Object... argus) {
        appendSQL(ss);
        for (Object item : argus) {
            argu.add(item);
        }
        return this;
    }

    public SQLUtil appendSQL(String s) {
        sql.append(" ").append(s);
        return this;
    }

    public SQLUtil addArgu(Object s) {
        argu.add(s);
        return this;
    }

    public String getSql() {
        return sql.toString();
    }

    public List<Object> getArgu() {
        return argu;
    }

    private SQLUtil cond(String column, String op, Object value) {
        if (!StringUtil.isEmpty(value) && !StringUtil.isEmpty(column)) {
            sql.append(" AND ").append(column).append(op).append("?");
            if (op.contains("LIKE")) {
                argu.add("%" + value + "%");
            } else {
                argu.add(value);
            }
        }
        return this;
    }

    public SQLUtil gt(String column, Object value) {
        return cond(column, " > ", value);
    }

    public SQLUtil lt(String column, Object value) {
        return cond(column, " < ", value);
    }

    public SQLUtil le(String column, Object value) {
        return cond(column, " <= ", value);
    }

    public SQLUtil ge(String column, Object value) {
        return cond(column, " >= ", value);
    }

    public SQLUtil ne(String column, Object value) {
        return cond(column, " <> ", value);
    }

    public SQLUtil eq(String column, Object value) {
        return cond(column, " = ", value);
    }

    public SQLUtil like(String column, Object value) {
        return cond(column, " LIKE ", value);
    }

}
