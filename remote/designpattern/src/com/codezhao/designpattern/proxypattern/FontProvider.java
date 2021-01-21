package com.codezhao.designpattern.proxypattern;

import java.awt.*;

/**
 * @author codeZhao
 * @date 2021/1/12  11:35
 * @Description 字体获取接口
 */
public interface FontProvider {
    Font getFont(String name);
}
