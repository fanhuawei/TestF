package cn.com.mobilereal.common.util;

public interface ConstUtil {

	public interface FLAG{
		String YES = "Y";
		String NO = "N";
	}	
	
	public interface ORDER_OPERATE{
	    String CREATE = "N"; //创建  
	    String DISPATCH = "D"; // 分发 是 
	    String RECEIVED = "E"; // 工程师收到工单 
	    String ARRIVE = "A"; // 到达现场 是 
	    String SUBMIT = "S"; // 提交 是 
	    String RETURN = "R"; //5 R 退回 是 
	    String CLOSE = "C" ; //6 C 关闭 

	}
	
	public interface ORDER_FILTER{
	    String TODO = "T"; //待办
	    String DONE = "D"; //已办
	    String ALL = "A"; //全部	    
	}
	
	public interface ORDER_STATUS {
        String CREATE = "A"; //创建，没有审核
        String PROCESS = "P"; //进行中
        String FINISH = "F"; //完成未关闭
        String CLOSE = "C"; //关闭
    }

    
    public interface NUM {
       int HOURS_PER_DAY = 24;
       int SECOND_PER_HOUR = 3600;
       int SECOND_PER_DAY = 24 * 3600;
       long MI_SECOND_PER_DAY = 24 * 3600 * 1000l;
    }
	
	public interface STATUS{
		int SUCCESS = 0;   //成功
		int LOGOUT = 100;  //退出登录
	}	
	

	public interface MAIN_DATA{
	    String DEPT_TYPE = "DEPT_TYPE";  //部门类型
	    String YES_NO = "YES_NO";  //是否标记
	    String REGION = "REGION";  //大区
	    String SERVICE_TYPE = "SERVICE_TYPE";  //服务类型
	    String WORK_FLAG = "WORK_FLAG";  //工单操作
	    String ERROR_CATEGORY = "ERROR_CATEGORY";  //故障类别
	    String WORK_ORDER_STATUS = "WORK_ORDER_STATUS";  //工单状态
	    String RUN_MODE = "RUN_MODE";  //运行方式
	    String RUN_STATE = "RUN_STATE";  //运行状态
	    String MACHINE_TYPE = "MACHINE_TYPE";  //设备类型
	    String OPERATE_RESULT = "OPERATE_RESULT";  //操作结果
	    String REPORT_TYPE = "REPORT_TYPE";  //报告类型

	}	

	public interface RESPONSE{
        int UNLICENSE = 100;   //设备未授权，请与管理员联系
        int LOST = 200;        //设备已挂失，请与管理员联系
        int FREE = 250;        //设备处于空闲状态，请与管理员联系
        
        int USER_NAME_ERROR = 500; //用户名不正确
        int PASS_NONE = 510; //密码不正确
        
    }
	public interface BOX_DATA_MODE {
	    String I = "1";
	    String U = "0";
	}
	//机器数据状态
	public interface MACHINE_DATA_STATUS {
	    String NORMAL = "A";  //正常
	    String WARN = "B";    //警告
	    String STOP = "C";    //停机
	}
	//机器运行状态
	public interface MACHINE_RUN_STATUS {
	    String NORMAL = "A"; //正常
	    String STOP = "C";   //停机
	}
	
	//用户角色编码
	public interface USER_ROLE_CODE {
		String ADMINISTRATOR = "Administrator"; //系统管理员
		String SERVICE_CENTER_EMP = "Service_Center_Emp"; //服务中心客服
		String SERVICE_CENTER_MANAGER = "Service_Center_Manager"; //服务中心主管
		String REGIONAL_REPAIR_MANAGER = "Regional_Repair_Manager"; //区域服务中心主管
		String AGENT_MANAGER = "Agent_Manager"; //代理商主管
		String ENGINEER = "Engineer"; //维修工程师
		String REPAIR_SHOP_MANAGER = "Repair_Shop_Manager"; //维修车间主管
	}
	
	//工单流转类型
	public interface WORK_ORDER_FLOW_TYPE {
		String N = "工单创建"; //创建
		String D = "工单已由%s【%s】分发给%s【%s】"; //分发
		String A = "工程师【%s】到达现场"; //到达现场
		String S = "工程师【%s】提交了报告，工单已完成"; //提交
		String R = "%s【%s】将工单退回到%s【%s】"; //退回
		String C = "%s【%s】关闭了工单"; //关闭
	}
	//部门类型
	public interface DEPT_TYPE
	{
	    String COMAPNY = "C";  //公司IT
	    String COMAPNY_SERVICE_CENTER = "G";  //公司服务中心
	    String REGIONAL_SERVICE_CENTER = "S";  //区域服务中心
	}
	public interface AREA_FLAG {
	    String PROVINCE = "P";  //省
	    String CITY = "C"; //城市
	    String DISTRICT = "D"; //区县
	}
}
