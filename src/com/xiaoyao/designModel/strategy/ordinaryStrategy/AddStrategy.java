package com.xiaoyao.designModel.strategy.ordinaryStrategy;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-25
 */
public class AddStrategy implements Strategy {
    @Override
    public int exec(int a, int b) {
        int add = 0;
        add = a + b;
        System.out.println( a + " + "+ b + " = "  + add);
        return add;
    }
}
