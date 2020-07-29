package com.xiaoyao.designModel.proxy;

/**
 * @author ljp
 * @version 1.0
 * @since 2020-07-28
 * 被代理接口，JDK的动态代理必须通过实现接口的方式
 */
public interface Subject {
    void request();
}
