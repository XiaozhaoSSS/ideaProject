package com.codezhao.designpattern.proxypattern.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author codeZhao
 * @date 2021/1/14  16:22
 * @Description 方法拦截器，实现日志打印
 */
public class LoggerMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Logger: enter method " + method.getName() + "() ...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("Logger: quit method " + method.getName() + "() ...");
        return result;
    }
}
