package com.codezhao.rmitest.byrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author codeZhao
 * @date 2021/1/11  10:33
 * @Description 远程对象接口
 */
public interface Rectangle extends Remote {
    public void setLength(double length) throws RemoteException;
    public void setWidth(double width) throws RemoteException;
    public double getArea() throws RemoteException;
}
