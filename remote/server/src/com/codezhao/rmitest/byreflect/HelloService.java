package com.codezhao.rmitest.byreflect;

import java.util.Date;

/**
 * @author codeZhao
 * @date 2021/1/11  14:06
 * @Description 远程对象接口
 */
public interface HelloService {
    public String echo(String msg);
    public Date getTime();
}
