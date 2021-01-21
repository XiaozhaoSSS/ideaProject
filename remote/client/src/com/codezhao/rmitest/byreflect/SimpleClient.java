package com.codezhao.rmitest.byreflect;

import java.io.*;
import java.net.Socket;

/**
 * @author codeZhao
 * @date 2021/1/11  22:05
 * @Description 客户端，远程方法调用实现
 */
public class SimpleClient {
    public void invoke() throws Exception {
        Socket socket = new Socket("localhost", 8083);
        OutputStream out = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        InputStream in = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(in);

        //创建远程对象
        Call call = new Call("com.codezhao.rmitest.byreflect.HelloService",
                "echo",
                new Class[]{String.class},
                new Object[]{"Java"});
        oos.writeObject(call); //向服务端发送Call对象
        call = (Call) ois.readObject(); //接收服务端返回的Call对象
        System.out.println(call.getResult());
        ois.close();
        oos.close();
        socket.close();
    }
    public static void main(String[] args) throws Exception {
        SimpleClient client = new SimpleClient();
        client.invoke();
    }
}
