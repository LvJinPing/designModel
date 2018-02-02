package com.xiaoyao.designModel.model;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class Client {
    public static void main(String[] args) {
        HummerModel h1 = new HummerH1Model();
        HummerModel h2 = new HummerH2Model();
        h1.run();
        h2.run();

    }
}
