package com.xiaoyao.designModel.command;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 页面组
 */
public class PageReceiver implements Receiver {
    @Override
    public void find() {
        System.out.println("找到页面组");
    }

    @Override
    public void add() {
        System.out.println("增加页面");
    }

    @Override
    public void delete() {
        System.out.println("删除页面");

    }
}
