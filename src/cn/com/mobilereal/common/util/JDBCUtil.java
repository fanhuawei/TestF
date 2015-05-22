package cn.com.mobilereal.common.util;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import cn.com.mobilereal.common.dao.BaseBean;

public class JDBCUtil {
	private static transient Logger log = Logger.getLogger(JDBCUtil.class);
	
	private static DataSource ds;
	
    protected static void printError(Throwable thr){
        StringWriter sw = new StringWriter();
        thr.printStackTrace(new PrintWriter(sw));
        log.error(sw.toString());
    }
	
	public static void setDataSource(DataSource dataSource) {
		ds = dataSource;
	}
	
	public static void tryTrans(int retry) throws Exception {
		Connection conn = getConnection();
		try {
		  if (conn.getAutoCommit()){
			conn.setAutoCommit(false);
		  }
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
			}
			ThreadLocalBean.setDBConnection(null);
			ThreadLocalBean.setRollBack(null);
			throw e;
		}
	}
	protected static void beginPkTransaction() {
		Connection conn = getPkConnection();
		try {
		  if (conn.getAutoCommit()){
			conn.setAutoCommit(false);
		  }
		} catch (SQLException e) {
		    printError(e);
			try {
				conn.close();
			} catch (SQLException e1) {
			}
		}
	}
	public static void beginTransaction() {
		for (int i = 0; i < 3; i++) {
			try {
				tryTrans(i);
				return;
			} catch (Exception e) {
				try {
					Thread.sleep(500);
				} catch (Exception e1) {
				}
			}
		}
		throw new RuntimeException("数据库事务启动失败");
	}
	protected static void commitPk() {
	   	Connection conn = getPkConnection();
		if (conn==null) return;
		try {
			if (!conn.getAutoCommit()){
			conn.commit();}
		} catch (SQLException e) {
		    printError(e);
			throw new RuntimeException("数据库操作失败");
		} finally {
			closeAll(conn, null, null);
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
			ThreadLocalBean.setPKConnection(null);
		}
	}

	public static void rollbackPk() {
		Connection conn = getPkConnection();
		 if (conn==null) return;
		try {
			if (!conn.getAutoCommit()){
			conn.rollback();}
		} catch (SQLException e) {
		    printError(e);
			throw new RuntimeException("数据库操作失败");
		} finally {
			closeAll(conn, null, null);
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
			ThreadLocalBean.setPKConnection(null);
		}
	}
	public static void commit() {
	    if (ThreadLocalBean.getDBConnection()==null) return;
		Connection conn = getConnection();
		try {
			if (!conn.getAutoCommit()){
			conn.commit();}
		} catch (SQLException e) {
		    printError(e);
			throw new RuntimeException("数据库操作失败");
		} finally {
			closeAll(conn, null, null);
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
			ThreadLocalBean.setDBConnection(null);
			ThreadLocalBean.setRollBack(null);
		}
	}

	public static void rollback() {
		Connection conn = getConnection();
		try {
		   if (!conn.getAutoCommit()){
			 conn.rollback();
		   }
		} catch (SQLException e) {
		    printError(e);
			throw new RuntimeException("数据库操作失败");
		} finally {
			closeAll(conn, null, null);
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
			ThreadLocalBean.setDBConnection(null);
			ThreadLocalBean.setRollBack(null);
		}
	}

	private static Connection getConnection() {
		Connection conn = ThreadLocalBean.getDBConnection();
		if (conn != null) {
			try {
				if (conn.isClosed()) {
					log.warn("数据库连接被关闭.");
				} else {
					return conn;
				}
			} catch (SQLException e) {
			    printError(e);
			}
		}
		if (ds != null) {
			try {
				conn = ds.getConnection();
				log.info("数据源连接被创建。。。。。。。。。。。。。。。.autoCommit:" + conn.getAutoCommit() + " hash=" + conn.hashCode());
				ThreadLocalBean.setDBConnection(conn);
				return conn;
			} catch (Exception e) {
			    log.warn("数据源配置不正确");
			    printError(e);
				throw new RuntimeException("数据库连接失败");
			}
		} else {
		    log.warn("数据源未成功绑定");
			ConfigInfo info = ConfigInfo.getInstance();
			try {
				Class.forName(info.getJdbcDriver());
				conn = DriverManager.getConnection(info.getJdbcURL(),
						info.getJdbcUser(), info.getJdbcPass());
				log.debug("JDBC连接被创建。。。。。。。。。。。。。。。.");
				ThreadLocalBean.setDBConnection(conn);
				return conn;
			} catch (Exception e) {
				throw new RuntimeException("数据库连接失败",e);
			}
		}
	}
	private static Connection getPkConnection() {
		Connection conn = ThreadLocalBean.getPKConnection();
		if (conn != null) {
			try {
				if (conn.isClosed()) {
					log.warn("数据库连接被关闭.");
				} else {
					return conn;
				}
			} catch (SQLException e) {
			    printError(e);
			}
		}
		if (ds != null) {
			try {
				conn = ds.getConnection();
				log.info("PK 数据源连接被创建。。。。。。。。。。。。。。。." + conn.hashCode());
				ThreadLocalBean.setPKConnection(conn);
				return conn;
			} catch (Exception e) {
			    log.warn("数据源配置不正确");
			    printError(e);
				throw new RuntimeException("数据库连接失败");
			}
		} else {
		    log.warn("数据源未成功绑定");
			ConfigInfo info = ConfigInfo.getInstance();			
			try {
				Class.forName(info.getJdbcDriver());
				conn = DriverManager.getConnection(info.getJdbcURL(),
						info.getJdbcUser(), info.getJdbcPass());
				log.debug("PK JDBC连接被创建。。。。。。。。。。。。。。。.");
				ThreadLocalBean.setPKConnection(conn);
				return conn;
			} catch (Exception e) {
				throw new RuntimeException("数据库连接失败",e);
			}
		}
	}
	private static void closeAll(Connection conn, PreparedStatement prst,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (prst != null) {
			try {
				prst.close();
			} catch (SQLException e) {
			}
		}

		if (conn != null) {
			try {
			  if (conn == ThreadLocalBean.getDBConnection()){
				if (conn.getAutoCommit()) {
					conn.close();
					ThreadLocalBean.setDBConnection(null);
				}
			  }else if (conn == ThreadLocalBean.getPKConnection()){
				  if (conn.getAutoCommit()) {
						conn.close();
						ThreadLocalBean.setPKConnection(null);
				 }
			  }
			} catch (SQLException e) {
			}
		}
	}
	protected static int doUpdatePk(String sql, Object... argus) {
		Connection conn = getPkConnection();
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement(sql);
			int i = 1;
            if (argus != null) {
                for (Object item : argus) {
                    prst.setObject(i, item);
                    i++;
                }
            }
			return prst.executeUpdate();
		} catch (SQLException e) {
		    printSQL(sql, argus);
			throw new RuntimeException("数据库操作失败",e);
		} finally {
			closeAll(conn, prst, null);
		}

	}
	public static int doUpdate(String sql, Object... argus) {
		Connection conn = getConnection();
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement(sql);
			int i = 1;
            if (argus != null) {
                for (Object item : argus) {
                    prst.setObject(i, item);
                    i++;
                }
            }
			return prst.executeUpdate();
		} catch (SQLException e) {
		    printSQL(sql, argus);
			throw new RuntimeException("数据库操作失败",e);
		} finally {
			closeAll(conn, prst, null);
		}

	}
	public static List<String> doQueryStringValueList(String sql, Object... argus) {
	    List<String> ret = new ArrayList<String>();
	    Connection conn = getConnection();
        PreparedStatement prst = null;
        ResultSet rs = null;
        try {
            prst = conn.prepareStatement(sql);
            int i = 1;
            if (argus != null) {
                for (Object item : argus) {
                    prst.setObject(i, item);
                    i++;
                }
            }
            rs = prst.executeQuery();
            while (rs.next()) {
               ret.add(rs.getString(1));
            }
            return ret;
        } catch (Throwable e) {
            printSQL(sql, argus);
            throw new RuntimeException("数据库操作失败",e);
        } finally {
            closeAll(conn, prst, rs);
        }
	}
	public static List<Long> doQueryLongValueList(String sql, Object... argus) {
        List<Long> ret = new ArrayList<Long>();
        Connection conn = getConnection();
        PreparedStatement prst = null;
        ResultSet rs = null;
        try {
            prst = conn.prepareStatement(sql);
            int i = 1;
            if (argus != null) {
                for (Object item : argus) {
                    prst.setObject(i, item);
                    i++;
                }
            }
            rs = prst.executeQuery();
            while (rs.next()) {
               ret.add(rs.getLong(1));
            }
            return ret;
        } catch (Throwable e) {
            printSQL(sql, argus);
            throw new RuntimeException("数据库操作失败",e);
        } finally {
            closeAll(conn, prst, rs);
        }
    }
	
	public static Object doQuerySingleValue(String sql, Object... argus) {
	    Connection conn = getConnection();
        PreparedStatement prst = null;
        ResultSet rs = null;
        try {
            prst = conn.prepareStatement(sql);
            int i = 1;
            if (argus != null) {
                for (Object item : argus) {
                    prst.setObject(i, item);
                    i++;
                }
            }
            rs = prst.executeQuery();
            if (rs.next()) {
                return rs.getObject(1);
            }else{
              return null;
            }
        } catch (SQLException e) {
            printSQL(sql, argus);
            throw new RuntimeException("数据库操作失败",e);
        } finally {
            closeAll(conn, prst, rs);
        }
	}
	
	protected static Number doQueryPk(String sql, Object... argus) {
		Connection conn = getPkConnection();
		PreparedStatement prst = null;
		ResultSet rs = null;
		try {
			prst = conn.prepareStatement(sql);
			int i = 1;
            if (argus != null) {
                for (Object item : argus) {
                    prst.setObject(i, item);
                    i++;
                }
            }
			rs = prst.executeQuery();
			if (rs.next()) {
				return rs.getLong(1);
			}else{
			  return null;
			}
		} catch (SQLException e) {
		    printSQL(sql, argus);
			throw new RuntimeException("数据库操作失败",e);
		} finally {
			closeAll(conn, prst, rs);
		}
	}
	public static Map<String, Object> doQueryMap(String sql, Object... argus) {
		List<Map<String, Object>> list = doQuery(sql, argus);
		if (list.size() > 0)
			return list.get(0);
		return new HashMap<String, Object>();
	}

	
	public static PageBean doPageQuery(int pageNo, int pageSize, String sql,
			Object... argus) {
		int groupbyIndex = sql.toUpperCase().indexOf(" GROUP BY ");
		String newSQL = null;
		if (groupbyIndex > 0) {
			newSQL = "SELECT COUNT(*) CNT FROM (" + sql + ") Ass";
		} else {
			int fromIndex = sql.toUpperCase().lastIndexOf(" FROM ");
			int fromIndex1 = sql.toUpperCase().lastIndexOf(" FROM ",fromIndex);
			if (fromIndex1>0){
				newSQL = "SELECT COUNT(*) CNT FROM (" + sql + ") Ass";
			}else{
		    	newSQL = "SELECT COUNT(*) CNT " + sql.substring(fromIndex);
			}
		}
		Map<String, Object> ret = doQueryMap(newSQL, argus);
		Number totalRecord = (Number) ret.get("CNT");
		PageBean pageBean = new PageBean(pageNo, pageSize, totalRecord.intValue());
		int startIndex = pageBean.getStartIndex();
		if (ConfigInfo.$.getJdbcDriver().contains("oracle")){
	        sql = "SELECT * FROM  (SELECT A.*, ROWNUM RN FROM (" + sql + ") A WHERE ROWNUM <= " + (startIndex + pageSize) +")  WHERE RN > " + startIndex;  
		} else {
		    sql = sql + " LIMIT " + startIndex + "," + pageSize;
		}
		List<Map<String, Object>> retList = doQuery(sql, argus);
		pageBean.setList(retList);
		return pageBean;
	}
	
	public static <T extends BaseBean> PageBean doPageBeanQuery(Class<T> cls, int pageNo, int pageSize, String sql,
            Object... argus) {
	    List<T> retList = null;
	    PageBean pageBean = null;
        if (pageSize<=0){
            retList = doQueryBeanList(cls, sql, argus);
            pageBean = new PageBean(pageNo, pageSize, retList.size());
            pageBean.setList(retList);
            return pageBean;
        }
        int groupbyIndex = sql.toUpperCase().indexOf(" GROUP BY ");
        String newSQL = null;
        if (groupbyIndex > 0) {
            newSQL = "SELECT COUNT(*) CNT FROM (" + sql + ") Ass";
        } else {
            int fromIndex = sql.toUpperCase().lastIndexOf(" FROM ");
            int fromIndex1 = sql.toUpperCase().lastIndexOf(" FROM ",fromIndex);
            if (fromIndex1>0){
                newSQL = "SELECT COUNT(*) CNT FROM (" + sql + ") Ass";
            }else{
                newSQL = "SELECT COUNT(*) CNT " + sql.substring(fromIndex);
            }
        }
        Map<String, Object> ret = doQueryMap(newSQL, argus);
        Number totalRecord = (Number) ret.get("CNT");
        pageBean = new PageBean(pageNo, pageSize, totalRecord.intValue());
        int startIndex = pageBean.getStartIndex();
        if (ConfigInfo.$.getJdbcDriver().contains("oracle")){
            sql = "SELECT * FROM  (SELECT A.*, ROWNUM RN FROM (" + sql + ") A WHERE ROWNUM <= " + (startIndex + pageSize) +")  WHERE RN > " + startIndex;  
        } else {
            sql = sql + " LIMIT " + startIndex + "," + pageSize;
        }
        retList = doQueryBeanList(cls, sql, argus);
        pageBean.setList(retList);
        return pageBean;
    }

	public static PageBean doPageQuery(int pageNo, String sql, Object... argus) {
		return doPageQuery(pageNo, ConfigInfo.$.getPageSize(), sql, argus);
	}
	@SuppressWarnings("unchecked")
	public static <T extends BaseBean> List<T> doQueryBeanList(Class<T> cls,String sql,
			 Object... argus) {
		Connection conn = getConnection();
		PreparedStatement prst = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			prst = conn.prepareStatement(sql);
			int i = 1;
            if (argus != null) {
                for (Object item : argus) {
                    prst.setObject(i, item);
                    i++;
                }
            }
			rs = prst.executeQuery();
			while (rs.next()) {
				BaseBean bean = cls.newInstance();
				bean.proceseResult(rs);
				list.add((T)bean);
			} 
			return list;
		} catch (Exception e) {
		    printSQL(sql, argus);
			throw new RuntimeException("数据库操作失败",e);
		} finally {
			closeAll(conn, prst, rs);
		}
	}
	@SuppressWarnings("unchecked")
	public static <T extends BaseBean> T doQuerySimpleObject(Class<T> cls,String sql,
			 Object... argus) {
		Connection conn = getConnection();
		PreparedStatement prst = null;
		ResultSet rs = null;
		try {
			prst = conn.prepareStatement(sql);
			int i = 1;
            if (argus != null) {
                for (Object item : argus) {
                    prst.setObject(i, item);
                    i++;
                }
            }
			rs = prst.executeQuery();
			if (rs.next()) {
				BaseBean bean = cls.newInstance();
				bean.proceseResult(rs);
				return (T) bean;
			} else {
				return null;
			}
		} catch (Exception e) {
		    printSQL(sql, argus);
			throw new RuntimeException("数据库操作失败",e);
		} finally {
			closeAll(conn, prst, rs);
		}
	}

	@SuppressWarnings("finally")
	public static List<Map<String, Object>> doQuery(String sql, Object... argus) {
		Connection conn = getConnection();
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		PreparedStatement prst = null;
		ResultSet rs = null;
		try {
			prst = conn.prepareStatement(sql);
			int i = 1;
            if (argus != null) {
                for (Object item : argus) {
                    prst.setObject(i, item);
                    i++;
                }
            }
			rs = prst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int len = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String, Object> row = new TreeMap<String, Object>(
						String.CASE_INSENSITIVE_ORDER);
				for (i = 1; i <= len; i++) {
					row.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
				retList.add(row);
			}
		} catch (SQLException e) {
		    printSQL(sql, argus);
			throw new RuntimeException("数据库操作失败",e);
		} finally {
			closeAll(conn, prst, rs);
			return retList;
		}
	}

	private static String filterDollarStr(String str) {
		return str.replaceAll("\\$", "\\\\\\$");
	}

	private static void printSQL(String sql, Object... argu) {
		try {
			for (Object o : argu) {
				if (o == null) {
					sql = sql.replaceFirst("\\?", "NULL");
					continue;
				}
				if (o instanceof Number) {
					sql = sql.replaceFirst("\\?", o.toString());
					continue;
				}
				if (o instanceof String) {
					sql = sql.replaceFirst("\\?", "'"
							+ filterDollarStr((String) o) + "'");
					continue;
				}
				if (o instanceof Date) {
					sql = sql.replaceFirst(
							"\\?",
							"'"
									+ new SimpleDateFormat(
											"yyyy-MM-dd HH:mm:ss").format(o)
									+ "'");
					continue;
				}
			}
			log.warn(sql);
		} catch (Exception e) {
		    printError(e);
		}
	}
	
	public static void main(String[] args) {
      System.out.println(doQueryStringValueList("SELECT COMPANY FROM TT_EVALUATION_PERSON"));  
    }
}
