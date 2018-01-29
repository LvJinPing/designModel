package com.xiaoyao.designModel.memeto;

/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-29
 */
public class Client {
    public static void main(String[] args) {
        Boy b = new Boy();
        // 备忘录备份这种东西是否通过 事件的形式/组合观察者模式更好呢?就像记录日志一样。不影响主要的业务逻辑
        Caretaker caretaker = new Caretaker();
        b.setAge("11");
        b.setName("逍遥");
        b.setState("还可以");
        System.out.println(b);
        caretaker.setM(b.setMemeto());
        b.setState("不可以");
        System.out.println(b);
        b.restartMemeto(caretaker.getM());
        System.out.println(b);
    }
}
