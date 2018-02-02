package com.xiaoyao.designModel.command;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class AddRequirementCommand extends AbstractCommand {
    @Override
    public void execute() {
        super.requirementGroup.find();
        super.requirementGroup.add();
    }
}
