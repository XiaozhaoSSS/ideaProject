package com.codezhao.designpattern.proxypattern.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author codeZhao
 * @date 2021/1/14  14:23
 * @Description Cglib代理测试
 */
public class CglibTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\ideaProject");

        LoggerMethodInterceptor loggerMethodInterceptor = new LoggerMethodInterceptor();
        TimeMethodInterceptor timeMethodInterceptor = new TimeMethodInterceptor();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
//        enhancer.setCallbacks(new Callback[]{loggerMethodInterceptor, timeMethodInterceptor, NoOp.INSTANCE});
//        enhancer.setCallbackFilter(new PersonFilter());
        enhancer.setCallback(new LoggerMethodInterceptor());
        enhancer.setInterceptDuringConstruction(false);
        Person personProxy = (Person) enhancer.create(new Class[]{String.class}, new Object[]{"codeZhao"});
        System.out.println("-----------------");
//        personProxy.eat();
        System.out.println(personProxy.name);
        personProxy.run();
//        personProxy.say();
//        personProxy.sleep();

    }
}
