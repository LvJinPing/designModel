package com.xiaoyao.designModel.strategy.ordinaryStrategy;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-25
 * 策略模式
 * 策略模式接口。 提供基本方法
 */
public interface Strategy {
    /**
     * 策略模式具体执行方法
     */
    int exec(int a, int b);
}
