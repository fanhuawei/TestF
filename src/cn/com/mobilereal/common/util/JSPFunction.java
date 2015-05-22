package cn.com.mobilereal.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.com.mobilereal.common.ui.MenuActionEnum;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.framework.dbbean.MenuButton;
import cn.com.mobilereal.framework.dbbean.MenuFunction;
import cn.com.mobilereal.framework.service.MenuButtonService;

public class JSPFunction {
    static transient Logger  log = Logger.getLogger(JSPFunction.class);
    static final String[] makeNameById = new String[]{
        "USER",  "SELECT NAME FROM TS_USER WHERE ID=?",
        "AREA",  "SELECT NAME FROM TC_AREA WHERE ID=?",
        "ROLE",  "SELECT NAME FROM TS_ROLE WHERE ID=?",
        "DEVICE","SELECT NAME FROM TM_DEVICE WHERE ID=?",
        "DEPT",  "SELECT NAME FROM TS_DEPT WHERE ID=?",
        "FUNCTION",  "SELECT NAME FROM TS_MENU_FUNCTION WHERE ID=?"
    };
    
    static final String[] init = new String[]{
        "USER",         "SELECT ID,NAME FROM TS_USER",
        "AREA",         "SELECT ID,NAME FROM TC_AREA",
        "FUNCTION",     "SELECT ID,NAME FROM TS_MENU_FUNCTION",
        "ROLE",         "SELECT ID,NAME FROM TS_ROLE",
        "DEVICE",       "SELECT ID,NAME FROM TM_DEVICE",
        "DEPT",         "SELECT ID,NAME FROM TS_DEPT"        
    };
    
    public static String printError(Throwable e) {
        if (e != null) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return sw.toString();
        } else {
            return "";
        }
    }
    
    static Map<String,Object> codeValue = new HashMap<String,Object>();
    
   
    public static void init() {
        Map<String,Object> codeValue1 = new HashMap<String,Object>();
        String sql = "SELECT A.CODE ACODE, B.CODE,B.VALUE FROM TC_CODE_LIST A JOIN TC_CODE_DETAIL B ON A.ID=B.CODE_LIST_ID WHERE A.DELETE_MARK='N' AND B.DELETE_MARK='N';";
        List<Map<String,Object>> retList = JDBCUtil.doQuery(sql);
        codeValue1.clear();
        for (Map<String, Object> map : retList) {
            String key = map.get("ACODE") + ":" + map.get("CODE");
            codeValue1.put(key, map.get("VALUE"));
        }
        codeValue = codeValue1;
    }
    
    public static void initRequest(String listCode, Object... argus) {
        Map<Long, Object> dataMap = new HashMap<Long,Object>();
        StringBuilder sql = new StringBuilder();
        for (int i = 0; i < init.length; i = i + 2) {
            if (init[i].equalsIgnoreCase(listCode)) {                
                if (init[i+1].indexOf("GROUP BY")>0){
                    sql.append("SELECT * FROM (").append(init[i+1]).append(") A ");
                }else{
                    sql.append(init[i+1]);
                }
                sql.append(" WHERE ID=-1");
                if (argus.length>0) {                    
                    for (int j = 0; j < argus.length; j++) {
                        sql.append(" OR ID=? ");
                    }
                }
            }
        }        
        List<Map<String,Object>> retList = JDBCUtil.doQuery(sql.toString(), argus);
        for (Map<String, Object> map : retList) {
            dataMap.put(((Number)map.get("ID")).longValue(), map.get("NAME"));
        }
        ThreadLocalBean.getCache().put(listCode, dataMap);
    }
    
    @SuppressWarnings("unchecked")
    public static Boolean checkMenu(Long id) {
        List<MenuFunction> list = (List<MenuFunction>) ThreadLocalBean.getRequest().getSession()
                .getAttribute("userMenu");
        Boolean ret = Boolean.FALSE;
        if (id == null || list == null)
            return ret;
        for (MenuFunction item : list) {
            if (id.equals(item.getId())) {
                return true;
            }
        }
        return ret;
    }


    @SuppressWarnings("unchecked")
    public static Boolean checkButton(String code) {
        if (ConfigInfo.$.isCollectButton()) {
            return true;
        }
        MenuEnum menu = (MenuEnum)ThreadLocalBean.getRequest().getSession().getAttribute(ConfigInfo.$.getFunctionKey());
        Map<Long,List<MenuButton>> mbMap = (Map<Long,List<MenuButton>>)ThreadLocalBean.getRequest().getSession().getAttribute("userButton");
        if (menu == null || mbMap == null) {
            return false;
        }
        List<MenuButton> mbList = mbMap.get(menu.getId());
        if (mbList == null) {
          return false;
        }
        for (MenuButton mb : mbList) {
            if (code.equals(mb.getCode())){
              return true;
            }
        }
        return false;
    }
    public static String saveButton(Long menuId, String code, String value,String grant) {
        if (!ConfigInfo.$.isCollectButton()) {
           return "";
        }
        if (MenuButton.I.countByWhere("WHERE MENU_ID=? AND CODE=?", menuId, code) == 0) {
            MenuButton mb = new MenuButton();
            mb.setCode(code);
            mb.setName(value);
            mb.setGrantFlag(grant);
            mb.setMenuId(menuId);
            MenuButtonService.I.save(mb);
            return "*";
        } else {
            return "";
        }
    }
    
    public static String savePopupButton(Long menuId, String code, String value,String grant,String url) {
        if (!ConfigInfo.$.isCollectButton()) {
           return "";
        }
        saveButton(menuId,code,value,grant);
        
        return "";
    }
    

    public static Object makeValueByCode(String code, String flag) {
       String key = flag + ":" + code;
       Object value = codeValue.get(key);
       if (value == null){
         log.info(key);
         String sql = "SELECT B.VALUE FROM TC_CODE_LIST A JOIN TC_CODE_DETAIL B ON A.ID=B.CODE_LIST_ID WHERE A.DELETE_MARK='N' AND B.DELETE_MARK='N' AND B.CODE=? AND A.CODE=?";
         value =JDBCUtil.doQuerySingleValue(sql, code,flag);
         codeValue.put(key, value);
       }
       return value;
    }
    
    public static Object makeNameById(Long id, String flag) {
        if (id!=null && id.longValue()<=0) return null;
        Map<Long, Object> dataMap = ThreadLocalBean.getCache().get(flag);
        if (dataMap == null){
            dataMap = new HashMap<Long, Object>();
        }
        Object ret = dataMap.get(id);
        if (ret != null) {
            return ret;
        }
        for (int i = 0; i < makeNameById.length; i = i + 2) {
            if (makeNameById[i].equalsIgnoreCase(flag)) {
                ret = JDBCUtil.doQuerySingleValue(makeNameById[++i], id);
            }
        }        
        if (ret != null) {
            dataMap.put(id, ret);
        }
        return ret;
    }
    
    
    public static String makeActionName(String code) {
        String ret = code;
        MenuActionEnum[] enums = MenuActionEnum.values();
        for (MenuActionEnum item : enums) {
            if (code.equalsIgnoreCase(item.getAction())){
               return item.getDesc();
            }
        }
        return ret;        
    }
    public static Boolean contains(Object code,Object[] list) {
        Boolean ret = Boolean.FALSE;
        if (code == null || list == null) return ret;
        for (Object item : list) {
            if (code.equals(item)) {
                return true;
            }
        }
        return ret;        
    }

    public static String makeCheckState(Object code,Object[] list) {
        if (code == null || list == null) return "";
        for (Object item : list) {
            if (code.equals(item)) {
                return "checked=\"checked\"";
            }
        }
        return "";        
    }
    
    public static String makeDisplayValue(String code,String format) {
        Object bean = null;
        String propertyName = code;
        Object value = null;
        int idx = code.indexOf(".");
        if (idx > 0) {
            bean = ThreadLocalBean.getRequest().getAttribute(code.substring(0, idx));
            propertyName = code.substring(idx + 1);
            value = ThreadLocalBean.getRequest().makePropertyValue(bean,propertyName);
        }else{
            value = ThreadLocalBean.getRequest().getAttribute(code);
        }
        if (value == null) {
          return "";
        }
        if (StringUtil.isEmpty(format)){
            return value.toString();
        }
        if (value instanceof Date){
          return new SimpleDateFormat(format).format(value);
        }
        if (value instanceof Number){
            return new DecimalFormat(format).format(value);
        }
        return value.toString();      
    }
    
    public static String makeSingleCheckState(Object code, Object item) {
        if (code == null && item == null) return "checked=\"checked\"";
        if (code == null) return "";
        if (code.equals(item)) {
           return "checked=\"checked\"";
        }
        return "";        
    } 
     
}
