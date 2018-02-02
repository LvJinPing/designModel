package com.xiaoyao.designModel.command;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 抽象命令类。 一个命令组合了各种功能。是一种高内聚的设计模式
 */
public abstract class AbstractCommand {
    protected CodeReceiver codeGroup = new CodeReceiver();
    protected PageReceiver pageGroup = new PageReceiver();
    protected RequirementReceiver requirementGroup = new RequirementReceiver();
    public abstract void execute();
}
