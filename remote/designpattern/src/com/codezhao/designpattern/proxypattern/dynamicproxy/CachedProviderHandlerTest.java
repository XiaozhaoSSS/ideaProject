package com.codezhao.designpattern.proxypattern.dynamicproxy;

import com.codezhao.designpattern.proxypattern.FontProvider;
import com.codezhao.designpattern.proxypattern.FontProviderFromDisk;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

/**
 * @author codeZhao
 * @date 2021/1/12  15:07
 * @Description 动态代理测试
 */
public class CachedProviderHandlerTest {
    public static void main(String[] args) {
        //保存生成的代理类class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //生成被代理对象
        FontProvider fontProvider = new FontProviderFromDisk();
        //生成与被代理对象相关联的InvocationHandler
        CachedProviderHandler cachedProviderHandler = new CachedProviderHandler(fontProvider);
        //生成代理对象
        FontProvider fontProviderProxy = (FontProvider)Proxy.newProxyInstance(
                fontProvider.getClass().getClassLoader(),
                fontProvider.getClass().getInterfaces(),
                cachedProviderHandler);
//        $Proxy0 fontProviderProxy = new $Proxy0(cachedProviderHandler);
        //代理执行getFont()方法
        fontProviderProxy.getFont("xxx");

//        String proxyname = "com.codezhao.designpattern.proxypattern.dynamicproxy.$Proxy0";
//        byte[] classFile = ProxyGenerator.generateProxyClass(proxyname, FontProviderFromDisk.class.getInterfaces());
//        String path = "D:\\ideaProject\\remote\\designpattern\\src\\com\\codezhao\\designpattern\\proxypattern\\dynamicproxy\\FontProviderProxy.class";
//        try(FileOutputStream fos = new FileOutputStream(path)) {
//            fos.write(classFile);
//            fos.flush();
//            System.out.println("代理类class文件写入成功");
//        } catch (Exception e) {
//            System.out.println("写文件错误");
//        }
    }
}
