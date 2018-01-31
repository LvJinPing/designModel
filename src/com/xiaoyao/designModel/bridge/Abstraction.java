package com.xiaoyao.designModel.bridge;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 * 抽象化角色。定义角色的行为，并保持一个队实现化角色的引用
 */
public abstract class Abstraction {
    private Implementor i;

    public Abstraction(Implementor i) {
        this.i = i;
    }
    public abstract void request();
    public Implementor getI() {
        return i;
    }
}
