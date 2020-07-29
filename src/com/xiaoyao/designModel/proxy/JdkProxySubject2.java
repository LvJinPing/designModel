package com.xiaoyao.designModel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ljp
 * @version 1.0
 * @since 2020-07-28
 * 对 Subject 实现类的动态代理
 */
public class JdkProxySubject2 implements InvocationHandler {
    private Subject realSubject;

    public JdkProxySubject2(Subject subject) {
        this.realSubject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before2");
        Object result = null;
        try {
            result = method.invoke(realSubject, args);
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("after2");
        }
        return result;
    }

}
