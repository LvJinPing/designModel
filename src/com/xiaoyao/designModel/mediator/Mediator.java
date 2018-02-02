package com.xiaoyao.designModel.mediator;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 具体的采购类
 */
public class Mediator extends  AbstractMediator {
    public Mediator() {
    }

    @Override
    public void execute(String doSome, Object... params) {

    }
    // 采购电脑
// 各种同事类间方法调用关系通过 private 限定只能在本类中使用。
    // 所有的逻辑关系都封装到了里面
    private void buyComputer(int count){
        int saleStatus = super.sale.getSaleStatus();
        // 销售情况好
        if(saleStatus > 80){
            System.out.println("采购电脑  " + count + "台");
            super.stock.increase(count);
        }else {
            // 销售情况不好折半采购
            int buyNumber = count /2;
            System.out.println("采购电脑 " + buyNumber + " 台");
        }
    }
//销售电脑
    private  void saleComputer(int count){
        if(super.stock.getComputerNumber() < count){  // 库存不足
            super.purchase.buyComputer(count);
        }
        super.stock.decrease(count);
    }
    private void offSell(){
        System.out.println("折价销售电脑 " + stock.getComputerNumber() );
    }
    private void clearStock(){
        super.sale.offSale();
        // 要求采购人员不再采购电脑
        super.purchase.refuseBuyComputer();
    }
}
