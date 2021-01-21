package com.codezhao.designpattern.proxypattern.staticproxy;

import com.codezhao.designpattern.proxypattern.FontProvider;
import com.codezhao.designpattern.proxypattern.FontProviderFromDisk;

import java.awt.*;

/**
 * @author codeZhao
 * @date 2021/1/12  13:59
 * @Description 代理测试
 */
public class FontProviderProxyTest {
    public static void main(String[] args) {
        //生成被代理对象
        FontProvider fontProvider = new FontProviderFromDisk();
        //生成代理对象
        FontProviderProxy fontProviderProxy = new FontProviderProxy(fontProvider);
        //代理对象代理实现getFont()方法
        Font font = fontProviderProxy.getFont("xxx");
    }
}
