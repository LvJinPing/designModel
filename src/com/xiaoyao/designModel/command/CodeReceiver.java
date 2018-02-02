package com.xiaoyao.designModel.command;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 代码组
 */
public class CodeReceiver implements Receiver {
    @Override
    public void find() {
        System.out.println("找到代码组");
    }

    @Override
    public void add() {
        System.out.println("增加功能");
    }

    @Override
    public void delete() {
        System.out.println("删除功能");
    }
}
