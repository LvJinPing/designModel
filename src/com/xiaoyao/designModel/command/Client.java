package com.xiaoyao.designModel.command;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class Client {
    public static void main(String[] args) {
        Invoker i = new Invoker();
        System.out.println("删除页面");
        AbstractCommand command = new AddRequirementCommand();
        i.setCommand(command);
        i.action();
    }
}
