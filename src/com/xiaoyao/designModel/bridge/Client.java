package com.xiaoyao.designModel.bridge;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 */
public class Client {
    public static void main(String[] args) {
        Implementor i1 = new ConcreteImplementor1();
        Implementor i2 = new ConcreteImplementor2();
        Abstraction a1 = new RefinedAbstraction(i1);
        Abstraction a2 = new RefinedAbstraction(i2);
        a1.request();
        a2.request();
    }
}
