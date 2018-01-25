package com.xiaoyao.designModel.strategy.ordinaryStrategy;

import com.xiaoyao.designModel.strategy.ordinaryStrategy.Strategy;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-25
 */
public class SubStrategy implements Strategy {
    @Override
    public int exec(int a, int b) {
        int sub = 0;
        sub = a - b;
        System.out.println( a + " - "+ b + " = "  + sub);
        return sub;
    }

}
