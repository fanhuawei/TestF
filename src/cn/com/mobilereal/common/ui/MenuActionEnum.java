package cn.com.mobilereal.common.ui;

public enum MenuActionEnum {
	 INIT("init", "初始化"),
	 AJAX("ajax", "ajax测试"),
	 AJAX_SELECT("ajaxSelect", "下拉框联动"),
	 AJAX_DIV("ajaxDiv", "局部刷新"),
	 LOGIN("login", "登录"),
	 LOGOUT("logout", "退出"),
	 SEARCH("search", "查询"),
	 EDIT("edit", "编辑"), 
	 MODIFY("modify", "修改"), 
	 UPDATE("update", "更新"), 
	 VIEW("view", "查看"), 
	 ADD("add", "新增"), 
	 SAVE("save", "保存"), 
	 DEL("delete", "删除"),
	 SUBMIT("submit", "提交"), 
	 MARK_LOST("markLost", "挂失"),
	 CANCEL_LOST("cancelLost", "取消挂失"),
	 CLEAR("clear", "消除资料"),
	 CLOSE("close", "关闭"),
	 CANCEL("cancel", "取消"),
     SAVE_PASS("savePass", "更新密码"),
	 ASSIGN_USER("assignUser","分配用户"),
	 ASSIGN_ROLE("assignRole","分配角色"),	 
	 UPDATE_ROLE("updateRole","更新角色"), 
	 ASSIGN_RIGHT("assignRight","分配权限"),
	 DOWNLOAD("download", "下载"),
	 IMPORT("import", "导入"),
	 EXPORTDATA("exportData","导出"),
	 BACK("back","返回上一步"),
	 NEXT("nextStep","进入下一步"),	 
	 MOVE_UP("moveUp","上移"),
	 MOVE_DOWN("moveDown","下移"),	 
    EXPORT("export", "导出"),
    BIND("bind","绑定设备")
	;

	private String action;
	private String desc;

	private MenuActionEnum(String action, String desc) {
		this.action = action;
		this.desc = desc;
	}

	public String getAction() {
		return action;
	}

	public String getDesc() {
		return desc;
	}

}
