package com.codezhao.designpattern.proxypattern;

import java.lang.reflect.Modifier;
import java.util.HashMap;

/**
 * @author codeZhao
 * @date 2021/1/13  8:46
 * @Description
 */
public class NetTest extends FontProviderFromNet {
    public NetTest(String label) {
        super(label);
    }
    public void getLabel() {
        System.out.println(this.label);
        System.out.println(super.label);
    }

    public static void main(String[] args) {
        int m = Modifier.PRIVATE | Modifier.STATIC;
        System.out.println(m);

    }
}






