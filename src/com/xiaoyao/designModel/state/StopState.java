package com.xiaoyao.designModel.state;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 */
public class StopState extends LifeState {
    @Override
    public void run() {
        System.out.println("电梯运行");
        super.context.setLs(Context.rs);
    }

    @Override
    public void stop() {
        System.out.println("本来就是停止状态");
    }

    @Override
    public void open() {
        System.out.println("电梯门打开");
        super.context.setLs(Context.os);
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭");
        super.context.setLs(Context.cs);
    }
}
