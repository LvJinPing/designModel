package com.xiaoyao.designModel.state;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 */
public class OpenState extends LifeState {
    /**
     * 这些对象方法需要考虑线程安全问题吗? new 出来的对象不需要考虑。但单例对象则需要考虑这些事情
     */
    @Override
    public void run() {
        // 不能执行的抛异常还是返回个什么值就可以了
        System.out.println("open 状态下不能执行 run");
    }

    @Override
    public void stop() {
        System.out.println("open 状态下不需要执行 stop");
    }

    @Override
    public void open() {
        System.out.println("open 本来就是 open");
    }

    /**
     * 只有当前状态允许的动作有具体业务逻辑。并改变 Context 中的状态
     */
    @Override
    public void close() {
        System.out.println("电梯门正在关闭");
        super.getContext().setLs(Context.cs);
    }
}
