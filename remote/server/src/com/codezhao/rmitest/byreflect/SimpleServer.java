package com.codezhao.rmitest.byreflect;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author codeZhao
 * @date 2021/1/11  14:20
 * @Description 服务端，注册远程对象、接收客户端消息并处理
 */
public class SimpleServer {
    private Map remoteObjects = new HashMap<String, Object>(); //存放远程对象的缓存

    //将远程对象放入缓存
    public void register(String className, Object remoteObject) {
        remoteObjects.put(className, remoteObject);
    }

    public void server() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8083);
        System.out.println("server startup...");
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);
            OutputStream out = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);

            Call call = (Call) ois.readObject(); //接受客户端发来的Call对象
            System.out.println(call);
            call = invoke(call); //调用对应远程对象方法
            oos.writeObject(call);

            ois.close();
            oos.close();
            socket.close();
        }
    }

    //解析call中信息，调用对应远程对象的方法，将结果写入call中并返回
    public Call invoke(Call call){
        Object result = null;

        try {
            String className = call.getClassName();
            String methodName = call.getMethodName();
            Class[] paramTypes = call.getParamTypes();
            Object[] params = call.getParams();

            Class classType = Class.forName(className);
            Method method = classType.getMethod(methodName, paramTypes);
            Object remoteObject = remoteObjects.get(className);

            if (remoteObject == null) {
                throw new Exception(className + "的远程对象不存在");
            } else {
                result = method.invoke(remoteObject, params);
            }
        } catch (Exception e) {
            result = e;
        }

        call.setResult(result);
        return call;
    }

    public static void main(String[] args) throws Exception {
        SimpleServer server = new SimpleServer();
        server.register("com.codezhao.rmitest.byreflect.HelloService",
                new HelloServiceImpl());
        server.server();
    }
}
