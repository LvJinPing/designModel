package com.xiaoyao.designModel.state;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 */
public class Client {
    public static void main(String[] args) {
        // 涉及到各种组合状态怎么判断呢?  run/stop 与 open/close 状态最好是分开的接口。 个人觉得。组合有各种不同的状态啊。
        // 使用状态模式后，不需要大量的 switch/case or if/else 进行判读。 且客户端调用方便
        Context c = new Context();
        c.setLs(Context.cs);
        c.open();
        c.close();
//        c.run();
        c.stop();
    }
}
