package com.xiaoyao.designModel.visitor;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-30
 */
public class HahaVisitor implements Visitor {
    @Override
    public void visit(CommenElement element) {
        System.out.println("haha 的查看逻辑");
        System.out.println(element.toString());
    }

    @Override
    public void visit(MangerElement element) {
        System.out.println("haha 的查看逻辑");
        System.out.println(element.toString());
    }
}
