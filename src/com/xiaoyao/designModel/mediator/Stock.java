package com.xiaoyao.designModel.mediator;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 库管类
 */
public class Stock extends  AbstractColleague {

    public Stock(AbstractMediator mediator) {
        super(mediator);
    }
    private static  int COMPUTER_NUMBER = 100;
    // 增加库存
    public void increase(int count){
        COMPUTER_NUMBER = COMPUTER_NUMBER + count;
        System.out.println("库存数量为 ： " + COMPUTER_NUMBER);
    }
    // 降低库存
    public void decrease(int count){
        COMPUTER_NUMBER = COMPUTER_NUMBER - count;
        System.out.println("库存数量为 ： "+ COMPUTER_NUMBER);
    }
    // 通知采购人员不再采购
    public  void clearStock(){
        System.out.println("清理库存数量为：" + COMPUTER_NUMBER);
        super.mediator.execute("stock.clear");
    }

    public  int getComputerNumber() {
        return COMPUTER_NUMBER;
    }
}
