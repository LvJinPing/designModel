package com.xiaoyao.designModel.mediator;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 同事类抽象类
 */
public abstract class AbstractColleague {
    protected AbstractMediator mediator ;

    /**
     * 必需通过调用抽象类的有参构造器设置中介者
     * @param mediator
     */
    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
