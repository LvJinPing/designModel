package com.xiaoyao.designModel.model;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 悍马模版实现类 1
 */
public class HummerH1Model extends HummerModel {
    @Override
    protected void start() {
        System.out.println("H1 start");
    }

    @Override
    protected void stop() {
        System.out.println("H1 stop");
    }

    @Override
    protected void alarm() {
        System.out.println("H1 alarm");
    }
}
