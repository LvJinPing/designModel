package com.xiaoyao.designModel.builder;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class BenzCar extends AbstractCarModel {
    @Override
    protected void start() {
        System.out.println("Benz  start");
    }

    @Override
    protected void stop() {
        System.out.println("Benz  stop");
    }

    @Override
    protected void alarm() {
        System.out.println("Benz  alarm");
    }
}
