package com.xiaoyao.designModel.builder;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class BMWCar extends AbstractCarModel {
    @Override
    protected void start() {
        System.out.println("bmw  start");
    }

    @Override
    protected void stop() {
        System.out.println("bmw  stop");
    }

    @Override
    protected void alarm() {
        System.out.println("bmw  alarm");
    }
}
