package com.xiaoyao.designModel.mediator;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 中介者抽象类，提供具体抽象方法
 */
public abstract class AbstractMediator {
    // 包含每个同事类? 下放到子类更好吧
    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;

    public AbstractMediator() {
        // 实际使用中可能有些差别，取决于同事类是否有状态
        purchase = new Purchase(this);
        sale = new Sale(this);
        stock = new Stock(this);
    }
    public abstract void execute(String doSome,Object ... params);
}
