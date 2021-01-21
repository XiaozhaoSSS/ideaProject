package com.codezhao.rmitest.byrmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author codeZhao
 * @date 2021/1/11  11:07
 * @Description 注册远程对象
 */
public class BindRectangleServer {
    public static void main(String[] args) {
        try {
            RectangleImpl rectangle = new RectangleImpl();

            //远程对象注册表实例
            LocateRegistry.createRegistry(8083);

            //将远程对象注册到RMI注册服务器上
            Naming.bind("rmi://localhost:8083/Rectangle", rectangle);
            System.out.println("server:");
            System.out.println("绑定成功");
            while (true);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
