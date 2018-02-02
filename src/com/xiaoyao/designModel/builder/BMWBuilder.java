package com.xiaoyao.designModel.builder;

import java.util.List;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class BMWBuilder extends AbstractCarBuider {
    // 这里没有用 AbstractCarModel 是因为没有必要。  BMWBuilder 已经指定了这是 bmw 的创建者。若其有自己的个性方法，使用 BMWCar 的基类比较好
    private BMWCar bmw =  new BMWCar();
    @Override
    public void setSequence(List<String> sequence) {
        bmw.setSequence(sequence);
    }

    @Override
    public BMWCar getCarModel() {
        return this.bmw;
    }
}
