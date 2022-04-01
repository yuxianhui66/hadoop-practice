package com.calprice;

/**
 * @author yuxianhui
 * @create 2020-06-18 10:39
 **/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.SortedMap;

public class CalPriceProxy implements InvocationHandler{

    private SortedMap<Integer, Class<? extends CalPrice>> clazzMap;

    private CalPriceProxy(SortedMap<Integer, Class<? extends CalPrice>> clazzMap) {
        super();
        this.clazzMap = clazzMap;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Double result = 0D;
        if (method.getName().equals("calPrice")) {
            for (Class<? extends CalPrice> clazz : clazzMap.values()) {
                if (result == 0) {
                    result = (Double) method.invoke(clazz.newInstance(), args);
                }else {
                    result = (Double) method.invoke(clazz.newInstance(), result);
                }
            }
            return result;
        }
        return null;
    }

    public static CalPrice getProxy(SortedMap<Integer, Class<? extends CalPrice>> clazzMap){
        CalPrice calPrice = (CalPrice) Proxy.newProxyInstance(CalPriceProxy.class.getClassLoader(), new Class<?>[]{CalPrice.class}, new CalPriceProxy(clazzMap));
        return calPrice;
    }

}
