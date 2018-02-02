package com.xiaoyao.designModel.command;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public class Invoker  {
    private AbstractCommand command;

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }
    public void action(){
        this.command.execute();
    }
}
