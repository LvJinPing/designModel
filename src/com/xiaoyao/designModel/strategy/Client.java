package com.xiaoyao.designModel.strategy;


import com.xiaoyao.designModel.strategy.ordinaryStrategy.AddStrategy;
import com.xiaoyao.designModel.strategy.ordinaryStrategy.Context;
import com.xiaoyao.designModel.strategy.ordinaryStrategy.Strategy;
import com.xiaoyao.designModel.strategy.ordinaryStrategy.SubStrategy;

public class Client {
    public static void main(String[] args) {
        doOrdinaryStrategy("+",3,1);
    }
    private static void doOrdinaryStrategy(String cha , int a , int b){
        String add = "+";
        String sub = "-";
        Context c;
        Strategy s;
        // 策略模式中，客户端需要知道使用的策略是什么。与迪米特法则相违背。 通常与其他模式相结合使用
        // 这里的 if /else 可以交给 Context 进行创建
        if (add.equals(cha)) {
            s = new AddStrategy();
            c = new Context(s);
            System.out.println("执行 " + cha + "结果为" + c.exec(a, b));
        }else if (sub.equals(cha)){

            s = new SubStrategy();
            c = new Context(s);
            System.out.println("执行 " + cha + "结果为" +     c.exec(a , b));
        }
    }
}
