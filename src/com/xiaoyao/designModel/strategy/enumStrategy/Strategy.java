package com.xiaoyao.designModel.strategy.enumStrategy;

/**
 * 策略枚举。 可读性强，扩展性弱(枚举通常是不可变的)
 * 一个浓缩了策略模式的枚举
 */
public enum Strategy {
    ADD("+"){
        @Override
        public int exec(int a, int b) {
            System.out.println(a + " + " + b + "=" + (a +b));
            return a + b;
        }
    },
    SUB("-"){
        @Override
        public int exec(int a, int b) {
            System.out.println(a + " - " + b + "=" + (a -b));
            return  a - b;
        }
    };
    private String value = "";
    private Strategy( String value){
        this.value = value;
    }
    public abstract int exec(int a, int b);
}
