package com.xiaoyao.designModel.builder;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class Client {
    public static void main(String[] args) {
        Director d = new Director();
        BenzCar benMVP = d.getBenMVP();
        benMVP.run();
        // 最好新 new 一个 Director  用一个可能产生各种各样的问题。
        BMWCar bmwmvp = d.getBMWMVP();
        bmwmvp.run();
    }
}
