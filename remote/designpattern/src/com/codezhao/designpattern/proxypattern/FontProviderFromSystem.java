package com.codezhao.designpattern.proxypattern;

import java.awt.*;

/**
 * @author codeZhao
 * @date 2021/1/12  11:40
 * @Description 被代理对象
 */
public class FontProviderFromSystem implements FontProvider {
    @Override
    public Font getFont(String name) {
        System.out.println("get " + name + " from system.");
        return null;
    }
}
