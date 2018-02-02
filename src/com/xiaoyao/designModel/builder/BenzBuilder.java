package com.xiaoyao.designModel.builder;

import java.util.List;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class BenzBuilder extends AbstractCarBuider {
    private BenzCar benz =  new BenzCar();
    @Override
    public void setSequence(List<String> sequence) {
        benz.setSequence(sequence);
    }
// 重写方法返回值需要比父类小
    @Override
    public BenzCar getCarModel() {
        return this.benz;
    }
}
