package com.xiaoyao.designModel.mediator;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 销售 负责采购
 */
public class Purchase extends AbstractColleague {

    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    // 依赖行为  与其他同事有关联，必需通过中介者执行
    public void buyComputer(int count){

    }

    // 自发行为  与其他同事无关的行为
    public void refuseBuyComputer(){
        System.out.println("不再采购电脑");
    }
}
