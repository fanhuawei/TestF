package cn.com.mobilereal.common.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@SuppressWarnings("serial")
public abstract class BaseBean implements Serializable {
	private Long id;
	private Timestamp createTime;
	private Long createBy;
	private Long updateBy;
	private String deleteMark;
	private String remark;
	private Timestamp updateTime;
	/**
	 * 用于过滤页面
	 */
	private String keyword;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public String getDeleteMark() {
		return deleteMark;
	}

	public void setDeleteMark(String deleteMark) {
		this.deleteMark = deleteMark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Object[] makeRealArgu(boolean isInsert) {
		List<Object> list = makeArgu();
		if (isInsert) {
		    list.add(getDeleteMark());
		    list.add(getCreateBy());
			list.add(getCreateTime());
		}
		list.add(getUpdateBy());
		list.add(getUpdateTime());
		list.add(getId());
		return list.toArray();
	}
	public void proceseResult(ResultSet rs)  throws SQLException {
		id = rs.getLong("ID");
		createTime = rs.getTimestamp("CREATE_TIME");
		updateTime = rs.getTimestamp("UPDATE_TIME");
		createBy = makeLongValue(rs, "CREATE_BY");
		updateBy = makeLongValue(rs, "UPDATE_BY");
		remark = rs.getString("REMARK");
		deleteMark = rs.getString("DELETE_MARK");
		proceseResultSet(rs);
	}
	protected abstract List<Object> makeArgu();
	public abstract void proceseResultSet(ResultSet rs)  throws SQLException;
	
    /**
     * 
     * <p>Description: 获取结果集中的Long值</p>
     * @param rs 结果集
     * @param name 参数名
     * @return 参数值
     * @throws SQLException 异常
     */
	protected Long makeLongValue(ResultSet rs, String name) throws SQLException {
        if (rs.getObject(name) != null) {
            return rs.getLong(name);
        }
        return null;
    }
}
