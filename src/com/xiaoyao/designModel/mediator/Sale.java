package com.xiaoyao.designModel.mediator;

import java.util.Random;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 销售类
 */
public class Sale extends AbstractColleague {

    public Sale(AbstractMediator mediator) {
        super(mediator);
    }
    public void saleComputer(int count){
        super.mediator.execute("sale.sale",count);
        System.out.println("销售电脑" + count + "台");
    }
    public int getSaleStatus(){
        Random rand = new Random(System.currentTimeMillis());
        int saleStatus  = rand.nextInt(100);
        System.out.println("电脑销售情况为 " + saleStatus);
        return saleStatus;
    }
    public void offSale(){
        super.mediator.execute("sale.offsell");
    }
}
