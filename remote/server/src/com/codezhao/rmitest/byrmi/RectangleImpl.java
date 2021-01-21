package com.codezhao.rmitest.byrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author codeZhao
 * @date 2021/1/11  10:36
 * @Description 远程对象实现类
 */
public class RectangleImpl extends UnicastRemoteObject implements Rectangle {
    private double length,width;
    public RectangleImpl() throws RemoteException {
        super();
    }

    @Override
    public void setLength(double length) throws RemoteException{
        this.length = length;
    }

    @Override
    public void setWidth(double width) throws RemoteException{
        this.width = width;
    }

    @Override
    public double getArea() throws RemoteException{
        return length * width;
    }
}
