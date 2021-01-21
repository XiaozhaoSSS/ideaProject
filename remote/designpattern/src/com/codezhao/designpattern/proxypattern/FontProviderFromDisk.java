package com.codezhao.designpattern.proxypattern;

import java.awt.*;

/**
 * @author codeZhao
 * @date 2021/1/12  11:37
 * @Description 被代理对象
 */
public class FontProviderFromDisk implements FontProvider {
    String name;
    @Override
    public Font getFont(String name) {
        System.out.println("get " + name + " from disk.");
        return null;
    }
}
