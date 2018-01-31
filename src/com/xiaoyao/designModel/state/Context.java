package com.xiaoyao.designModel.state;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 * 状态模式包装类
 */
public class Context {
    /**
     * 状态模式潜规则， 需要报
     */
    public static final CloseState cs = new CloseState();
    public static final OpenState os = new OpenState();
    public static final RunState rs = new RunState();
    public static final StopState ss = new StopState();

    private LifeState ls ;

    public Context() {

    }

    public void setLs(LifeState ls) {
        this.ls = ls;
        // 将当前环境通知到各个实现类
        this.ls.setContext(this);
    }

    public void run() {
        this.ls.run();
    }

    public void stop() {
        this.ls.stop();
    }

    public void open() {
        this.ls.open();
    }

    public void close() {
        this.ls.close();
    }

    public LifeState getLs() {
        return ls;
    }


}
