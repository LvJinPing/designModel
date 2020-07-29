package com.xiaoyao.designModel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ljp
 * @version 1.0
 * @since 2020-07-28
 * 对 Subject 实现类的动态代理
 */
public class JdkProxySubject implements InvocationHandler {
    private Subject realSubject;

    public JdkProxySubject(Subject subject) {
        this.realSubject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = null;
        try {
            result = method.invoke(realSubject, args);
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("after");
        }
        return result;
    }

}
