package com.xiaoyao.designModel.command;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class DeletePageCommand extends AbstractCommand {
    @Override
    public void execute() {
    super.pageGroup.find();
    super.pageGroup.delete();
    }
}
