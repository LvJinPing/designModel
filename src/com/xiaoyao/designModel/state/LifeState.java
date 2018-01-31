package com.xiaoyao.designModel.state;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 * 电梯状态抽象类
 */
public abstract class LifeState {
    /**
     * 状态封装类
     */
    protected Context context;

    public LifeState() {}

    /**
     * 定义 Life(电梯) 所有可以执行的方法
     */
    public abstract void run();

    public abstract void stop();

    public abstract  void open();

    public abstract void close();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
