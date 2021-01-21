package com.codezhao.rmitest.byreflect;

import java.io.Serializable;

/**
 * @author codeZhao
 * @date 2021/1/11  14:09
 * @Description Call对象，封装类名、方法名、参数、结果等，用于传输
 */
public class Call implements Serializable {

    private static final long serialVersionUID = 588914845779341422L;

    private String className; //类名
    private String methodName; //方法名
    private Class[] paramTypes; //方法参数类型
    private Object[] params; //方法参数值

    private Object result; //执行结果，方法正常运行时result为方法返回值，方法抛出异常时result为该异常

    public Call() {
    }

    public Call(String className, String methodName, Class[] paramTypes, Object[] params) {
        this.className = className;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SimpleServer{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
