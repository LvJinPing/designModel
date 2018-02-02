package com.xiaoyao.designModel.command;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 命令具体执行者抽象执行方法.
 */
public interface Receiver {
    void find();
    void add();
    void delete();
}
