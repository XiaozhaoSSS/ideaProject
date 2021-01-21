package com.codezhao.designpattern.proxypattern.cglibproxy;

/**
 * @author codeZhao
 * @date 2021/1/14  14:22
 * @Description 被代理类Person
 */
public class Person{
//    public Person() {
//        run();
//    }
    public String name;
    public Person(String name) {this.name = name;}
    final public void eat() {
        System.out.println("I'm eating...");
    }
    public void run() {
        System.out.println("I'm running...");
    }
//    public void say() {
//        System.out.println("I'm saying...");
//    }
//    public void sleep() {
//        System.out.println("I'm sleeping...");
//    }
}
