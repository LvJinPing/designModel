package com.xiaoyao.designModel.memeto;

/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-29
 * 备忘录管理类，用于管理备忘录。提供查询/删除等方法
 */
public class Caretaker {
    private Memeto m ;

    public Caretaker() {
    }

    public Memeto getM() {
        return m;
    }

    /**
     * 可能有具体的业务逻辑处理
     * @param m
     */
    public void setM(Memeto m) {
        this.m = m;
    }
}
