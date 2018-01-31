package com.xiaoyao.designModel.state;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 */
public class RunState extends LifeState {
    @Override
    public void run() {
        System.out.println("本来就是 run 状态");
    }

    @Override
    public void stop() {
        System.out.println("电梯停止 ");
        super.context.setLs(Context.ss);
    }

    @Override
    public void open() {
        System.out.println("运行状态不能执行 open");
    }

    @Override
    public void close() {
        System.out.println("运行状态本来就是 close");
    }
}
