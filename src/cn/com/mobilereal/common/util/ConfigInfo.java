package cn.com.mobilereal.common.util;




public class ConfigInfo {

	private ConfigInfo(){}
	
	public static ConfigInfo $ = new ConfigInfo();
	
	public static ConfigInfo getInstance(){
		return $;
	}
	private boolean debug = true;
	private boolean log = true;
	private boolean collectButton = true; //收集权限按钮
	/**
	 * 检查权限，产品环境应为true
	 */
	private boolean checkRight = false;
	
	//是否对没有登录的请求，拦截到登录页面。产品环境应设为true;
	private boolean loginAccess = false;
	//分页数据显示的记录数
	private int pageSize = 20;  
	
	private String assetPath = "/wasshare/gd/";
	private String userKey = "UserInfo";
	private String actionKey = "currentActionObject";
	private String menuKey = "currentMenu";  //用于处理页面，选中状态的菜单
	private String functionKey = "currentFunction";  //当前功能页面
	private String contextPath="/gd";
	private String contextRealPath="D:/workspace/GD/WebRoot/";
	 
//	private String jdbcDriver="oracle.jdbc.OracleDriver";
//	private String jdbcURL="jdbc:oracle:thin:@10.122.5.236:1521/SOP";
//	//jdbc:oracle:thin:@180.96.63.240:1521:XE
//	private String jdbcUser="fbs";
//	private String jdbcPass="abc123";  //fbs
    private String jdbcDriver="com.mysql.jdbc.Driver";
    private String jdbcURL="jdbc:mysql://180.96.63.241/GD?useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
    //jdbc:oracle:thin:@180.96.63.240:1521:XE
    private String jdbcUser="root";
    private String jdbcPass="123!@#qwe";  //fbs	
	private Long initPK = 10000000l; 
	
	private String ldapDomain = "DC=CSVW,DC=COM";
	private String ldapUrl = "ldap://10.122.5.212:389/DC=CSVW,DC=COM";
	private String ldapFactory = "com.sun.jndi.ldap.LdapCtxFactory";
	private String ldapVer;
	private String ldapPrincipal = "uid=fbsadmin, cn=appadmins, cn=apps, DC=CSVW,DC=COM";
	private String ldapCredentials = "fbsadmin";
	private String ldapAuthentication = "simple";
	private String ldapServerCode = "svwapp_123=true";  //123
	
	
	//mobile_baidu_info apiKey secretkey
	private String apikey = "vca3EdA2BfIe7PTx22yKSGNk";
	private String secretkey = "kqRRTf0SLIsAZFpaviFpylpAaX8mIo6l";
	
	public boolean isCollectButton() {
        return this.collectButton;
    }
    public void setCollectButton(boolean collectButton) {
        this.collectButton = collectButton;
    }
    public boolean isCheckRight() {
        return this.checkRight;
    }
    public void setCheckRight(boolean checkRight) {
        this.checkRight = checkRight;
    }
    public String getLdapVer() {
        return this.ldapVer;
    }
    public void setLdapVer(String ldapVer) {
        this.ldapVer = ldapVer;
    }
    public String getLdapDomain() {
        return this.ldapDomain;
    }
    public void setLdapDomain(String ldapDomain) {
        this.ldapDomain = ldapDomain;
    }
    public String getLdapUrl() {
        return this.ldapUrl;
    }
    public void setLdapUrl(String ldapUrl) {
        this.ldapUrl = ldapUrl;
    }
    public String getLdapFactory() {
        return this.ldapFactory;
    }
    public void setLdapFactory(String ldapFactory) {
        this.ldapFactory = ldapFactory;
    }
    public String getLdapPrincipal() {
        return this.ldapPrincipal;
    }
    public void setLdapPrincipal(String ldapPrincipal) {
        this.ldapPrincipal = ldapPrincipal;
    }
    public String getLdapCredentials() {
        return this.ldapCredentials;
    }
    public void setLdapCredentials(String ldapCredentials) {
        this.ldapCredentials = ldapCredentials;
    }
    public String getLdapAuthentication() {
        return this.ldapAuthentication;
    }
    public void setLdapAuthentication(String ldapAuthentication) {
        this.ldapAuthentication = ldapAuthentication;
    }
    public String getLdapServerCode() {
        return this.ldapServerCode;
    }
    public void setLdapServerCode(String ldapServerCode) {
        this.ldapServerCode = ldapServerCode;
    }
    public String getFunctionKey() {
        return this.functionKey;
    }
    public void setFunctionKey(String functionKey) {
        this.functionKey = functionKey;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public String getMenuKey() {
        return menuKey;
    }
    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }
    public boolean isLoginAccess() {
        return loginAccess;
    }
    public void setLoginAccess(boolean loginAccess) {
        this.loginAccess = loginAccess;
    }
    public String getActionKey() {
		return actionKey;
	}
	public void setActionKey(String actionKey) {
		this.actionKey = actionKey;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getAssetPath() {
		return assetPath;
	}
	public void setAssetPath(String assetPath) {
		this.assetPath = assetPath;
	}
	
	public Long getInitPK() {
		return initPK;
	}
	public void setInitPK(Long initPK) {
		this.initPK = initPK;
	}
	
	public String getContextRealPath() {
		return contextRealPath;
	}
	public void setContextRealPath(String contextRealPath) {
		this.contextRealPath = contextRealPath;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public String getJdbcDriver() {
		return jdbcDriver;
	}
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	public String getJdbcURL() {
		return jdbcURL;
	}
	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}
	public String getJdbcUser() {
		return jdbcUser;
	}
	public void setJdbcUser(String jdbcUser) {
		this.jdbcUser = jdbcUser;
	}
	public String getJdbcPass() {
		return jdbcPass;
	}
	public void setJdbcPass(String jdbcPass) {
		this.jdbcPass = jdbcPass;
	}

	public boolean isLog() {
        return log;
    }
    public void setLog(boolean log) {
        this.log = log;
    }
    public boolean isDebug() {
		return debug;
	}
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
    public String getApikey() {
        return apikey;
    }
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
    public String getSecretkey() {
        return secretkey;
    }
    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }
	
}
