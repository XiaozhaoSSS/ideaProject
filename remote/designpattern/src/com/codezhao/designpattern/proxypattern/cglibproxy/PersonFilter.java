package com.codezhao.designpattern.proxypattern.cglibproxy;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author codeZhao
 * @date 2021/1/15  8:25
 * @Description
 */
public class PersonFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if ("run".equals(method.getName())) {
            return 0;
        }else if ("say".equals(method.getName())) {
            return 1;
        }
        return 2;
    }
}
