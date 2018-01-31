package com.xiaoyao.designModel.bridge;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 */
public class ConcreteImplementor1 implements Implementor {
    @Override
    public void doSometing1() {
        System.out.println("1:  sm1");
    }

    @Override
    public void doSometing2() {
        System.out.println("1: sm2");
    }
}
