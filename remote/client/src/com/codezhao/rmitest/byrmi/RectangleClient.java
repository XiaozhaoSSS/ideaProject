package com.codezhao.rmitest.byrmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author codeZhao
 * @date 2021/1/11  11:21
 * @Description 客户端调用
 */
public class RectangleClient {
    public static void main(String[] args) {

        try {
            //根据url在RMI注册表中查找远程对象
            Remote remote = Naming.lookup("rmi://localhost:8083/Rectangle");
            Rectangle rectangle = (Rectangle) remote;

            //调用远程对象方法
            rectangle.setLength(3);
            rectangle.setWidth(4);
            double area = rectangle.getArea();
            System.out.println("client:");
            System.out.println("area:" + area);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
