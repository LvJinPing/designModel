package com.xiaoyao.designModel.strategy.ordinaryStrategy;

public class Context {
    private Strategy s;

    public Context(Strategy s){
        this.s = s;
    }

    /**
     * 策略封装类执行策略的方法。
     * 策略调用者需要知道使用的是什么策略
     * @param a
     * @param b
     * @return 处理结果
     */
    public int exec(int a , int b){
        return  this.s.exec(a,b);
    }
}
