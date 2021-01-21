package com.codezhao.rmitest.byreflect;

import java.util.Date;

/**
 * @author codeZhao
 * @date 2021/1/11  14:07
 * @Description 远程对象实现
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String echo(String msg) {
        return "echo" + msg;
    }

    @Override
    public Date getTime() {
        return new Date();
    }
}
