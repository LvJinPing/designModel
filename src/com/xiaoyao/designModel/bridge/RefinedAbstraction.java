package com.xiaoyao.designModel.bridge;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 *
 */
public class RefinedAbstraction extends  Abstraction {
    public RefinedAbstraction(Implementor i) {
        super(i);
    }

    @Override
    public void request() {
        System.out.println("redifned1");
        super.getI().doSometing2();
        super.getI().doSometing1();
    }
}
