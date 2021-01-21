package com.codezhao.designpattern.proxypattern.staticproxy;

import com.codezhao.designpattern.proxypattern.FontProvider;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author codeZhao
 * @date 2021/1/12  11:46
 * @Description 代理类
 */
public class FontProviderProxy implements FontProvider {
    //被代理对象
    private FontProvider fontProvider;
    //缓存
    private Map<String, Font> cached = new HashMap<>();

    public FontProviderProxy(FontProvider fontProvider) {
        this.fontProvider = fontProvider;
    }

    //代理获取字体方法，调用被代理对象的获取字体方法
    @Override
    public Font getFont(String name) {
        //从缓存中获取
        Font font = cached.get(name);
        if (font == null) {
            //缓存获取不到，则调用被代理对象
            font = fontProvider.getFont(name);
            cached.put(name, font);
        }
        return font;
    }
}
