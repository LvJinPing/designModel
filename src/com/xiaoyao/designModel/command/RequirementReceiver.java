package com.xiaoyao.designModel.command;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 需求组
 */
public class RequirementReceiver implements Receiver {
    @Override
    public void find() {
        System.out.println("找到需求组");
    }

    @Override
    public void add() {
        System.out.println("客户增加需求");
    }

    @Override
    public void delete() {
        System.out.println("客户删除需求");
    }
}
