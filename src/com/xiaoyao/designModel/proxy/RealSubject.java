package com.xiaoyao.designModel.proxy;

/**
 * @author ljp
 * @version 1.0
 * @since 2020-07-28
 * 被代理对象
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject execute request()");
    }
}
