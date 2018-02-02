package com.xiaoyao.designModel.model;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class HummerH2Model extends HummerModel {
    @Override
    protected void start() {
        System.out.println("H2 start");
    }

    @Override
    protected void stop() {
        System.out.println("H2 stop");
    }

    @Override
    protected void alarm() {
        System.out.println("H2 alarm");
    }
}
