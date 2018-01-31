package com.xiaoyao.designModel.flyWeight;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 */
public class ConcreteFlyweight1 extends FlyWeight {

    public ConcreteFlyweight1(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate() {
    // 业务操作
    }
}
