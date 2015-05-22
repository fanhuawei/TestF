package cn.com.mobilereal.common.util;

import org.apache.log4j.Logger;

import cn.com.mobilereal.common.dao.TableEnum;


public class PKUtil {
	private transient Logger logger = Logger.getLogger(getClass());
	public static PKUtil $ = new PKUtil();

	public static PKUtil getInstance() {
		return $;
	}
	public Long[] getPKs(TableEnum tableEnum,int cnt) {
		  try{
		    Long[] ret = new Long[cnt];
		    JDBCUtil.beginPkTransaction();
			String tableName = tableEnum.getTableName();
			String sql = "SELECT TVALUE FROM TS_SEQUENCE WHERE ID = ? FOR UPDATE";
			Number ii = JDBCUtil.doQueryPk(sql, getId(tableEnum));
			if (ii == null) {
				long pk = 10000000;
				sql = "INSERT INTO TS_SEQUENCE(ID,TNAME,TVALUE) VALUES(?,?,?)";
				JDBCUtil.doUpdatePk(sql, getId(tableEnum), tableName, pk + cnt);
				ii = pk;
			} else {
				sql = "UPDATE TS_SEQUENCE SET TVALUE=?, TNAME = ?,UPDATE_TIME=? WHERE ID = ?";
	            JDBCUtil.doUpdatePk(sql, ii.longValue() + cnt, tableName, DateUtil.getSystemTimestamp(), getId(tableEnum));
			}
			for (int i = 0; i < cnt; i++) {
				ret[i] = ii.longValue() + i;
			}
			return ret;
		  }finally{
			JDBCUtil.commitPk();
		  }
		}
	public Long getPK(TableEnum tableEnum) {
	  try{
	    JDBCUtil.beginPkTransaction();
		String tableName = tableEnum.getTableName();
		String sql = "SELECT TVALUE FROM TS_SEQUENCE WHERE ID = ? FOR UPDATE";
		Number ii = JDBCUtil.doQueryPk(sql, getId(tableEnum));
		if (ii == null) {
			long pk = 10000000;
			sql = "INSERT INTO TS_SEQUENCE(ID,TNAME,TVALUE) VALUES(?,?,?)";
			JDBCUtil.doUpdatePk(sql, getId(tableEnum), tableName, pk + 1);
			return pk;
		} else {
			sql = "UPDATE TS_SEQUENCE SET TVALUE=?, TNAME = ?,UPDATE_TIME=? WHERE ID = ?";
			JDBCUtil.doUpdatePk(sql, ii.longValue() + 1, tableName,DateUtil.getSystemTimestamp(), getId(tableEnum));
			return ii.longValue();
		}
	  }finally{
		JDBCUtil.commitPk();
	  }
	}
	public int getId(TableEnum tableEnum) {
	   return tableEnum.ordinal() + 1000;
	}
	
	private void initPK(TableEnum table) {
		try {
		    java.sql.Timestamp ts = DateUtil.getSystemTimestamp();
			long initValue = ConfigInfo.$.getInitPK();
			String sql = "SELECT MAX(ID) ID FROM " + table.getTableName();
			Number maxpk = JDBCUtil.doQueryPk(sql);
			Long pk = initValue;
			if (maxpk!= null && maxpk.longValue()>=initValue) {
				pk = maxpk.longValue()+1;
			}
			sql = "INSERT INTO TS_SEQUENCE(ID, TNAME,TVALUE,CREATE_TIME,UPDATE_TIME) VALUES(?,?,?,?,?)";
			JDBCUtil.doUpdatePk(sql, getId(table), table.getTableName(), pk, ts, ts );
		} catch (Exception e) {
		    logger.error(e);
			logger.error(String.format("Table:[%s]或ID不存在", table.getTableName()));
		}
	}

	public void initPK() {
		logger.info("初始化数据主键");
	    JDBCUtil.beginPkTransaction();	    
	    JDBCUtil.doUpdatePk("DELETE FROM TS_SEQUENCE");
		TableEnum[] tables = TableEnum.values();
		for (TableEnum table : tables) {
			initPK(table);
		}		
		JDBCUtil.commitPk();
		logger.info("初始化数据主键完成");
	}
	
	public static void main(String[] args) {
        PKUtil.$.initPK();
    }
}
