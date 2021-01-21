package com.codezhao.designpattern.proxypattern.dynamicproxy;

import com.codezhao.designpattern.proxypattern.FontProvider;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author codeZhao
 * @date 2021/1/12  14:17
 * @Description 生成InvocationHandler实现类，给被代理对象增加缓存功能
 */
public class CachedProviderHandler implements InvocationHandler {
    //被代理对象
    private Object target;
    //缓存
    private Map<String, Object> cached = new HashMap<>();

    public CachedProviderHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, java.lang.Object[] args) throws Throwable {
        String name = (String) args[0];
        Object result = cached.get(name);
        if (result == null) {
            result = method.invoke(target, args);
            cached.put(name, result);
        }
        return result;
    }
}
