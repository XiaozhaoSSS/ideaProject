package com.codezhao.designpattern.proxypattern;

import java.awt.*;

/**
 * @author codeZhao
 * @date 2021/1/12  11:39
 * @Description 被代理对象
 */
public class FontProviderFromNet implements FontProvider {
    protected String label;

    public FontProviderFromNet(String label) {
        this.label = label;
    }

    @Override
    public Font getFont(String name) {
        System.out.println("get " + name + " from net.");
        return null;
    }
}
