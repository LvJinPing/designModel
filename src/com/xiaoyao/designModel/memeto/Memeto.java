package com.xiaoyao.designModel.memeto;

/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-29
 * 备忘录。提供备份方法
 */
public class Memeto {
    private String state;

    public Memeto(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
