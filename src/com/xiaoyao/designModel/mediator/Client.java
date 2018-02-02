package com.xiaoyao.designModel.mediator;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class Client {
    public static void main(String[] args) {
        AbstractMediator mediator = new Mediator();
        System.out.println("采购电脑");
        Purchase p = new Purchase(mediator);
        p.buyComputer(100);
        System.out.println("销售电脑");
        Sale s = new Sale(mediator);
        s.saleComputer(50);
        System.out.println("库管清理电脑");
        Stock st = new Stock(mediator);
        st.clearStock();
    }
}
