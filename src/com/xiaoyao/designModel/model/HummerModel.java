package com.xiaoyao.designModel.model;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 基础模版抽象类。 创建悍马车的模版
 */
public abstract class HummerModel {
    /**
     * 启动
     * 最好不是 public
     */
    protected abstract void start();

    /**
     * 停止
     */
    protected abstract void stop();

    /**
     * 鸣笛
     */
    protected abstract void alarm();

    /**
     * 汽车运行
     * 具体方法由子类提供实现
     * 运行顺序由模版决定。不能更改
     */
    public void run(){
        this.alarm();
        this.start();
        this.stop();
    }
}
