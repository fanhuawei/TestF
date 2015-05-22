package cn.com.mobilereal.common.util;

import java.util.HashMap;
import java.util.Map;

import cn.com.mobilereal.common.service.Service;

@SuppressWarnings("unchecked")
public class ServiceFactory {
    private static Map<Class<?>, Object> serviceMap = new HashMap<Class<?>, Object>();

    public static <T extends Service> T makeService(Class<T> cls) {
        T service = (T)serviceMap.get(cls);
        if (service == null) {
            try {
                service = cls.newInstance();
                serviceMap.put(cls, service);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return service;

    }
}
