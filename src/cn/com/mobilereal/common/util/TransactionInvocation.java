package cn.com.mobilereal.common.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import cn.com.mobilereal.common.web.SynchronizedException;

public class TransactionInvocation implements InvocationHandler {

    private Object source;
    private Method[] methodList = Object.class.getDeclaredMethods();
    
    public TransactionInvocation(Object source){
       this.source = source;
       
    }    
    
    private boolean isObjectMethod(Method mm){
      for (Method method : methodList) {
        if (method.equals(mm)){
          return true;
        }
      }
      return false;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (isObjectMethod(method)){
            return method.invoke(source, args);
        } else {
            JDBCUtil.beginTransaction();
            try {
                Object res = method.invoke(source, args);
                JDBCUtil.commit();
                return res;
            } catch (SynchronizedException e) {
                JDBCUtil.rollback();
                throw e;
            } catch (Exception e) {
                JDBCUtil.rollback();
                throw e;
            }
        }
    }
}
