package com.codezhao.designpattern.proxypattern.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author codeZhao
 * @date 2021/1/15  8:15
 * @Description
 */
public class TimeMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("StartTime=" + System.currentTimeMillis());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("EndTime=" + System.currentTimeMillis());
        return result;
    }
}
