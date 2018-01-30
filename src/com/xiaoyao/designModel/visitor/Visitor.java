package com.xiaoyao.designModel.visitor;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-30
 * 访问者，提供具体的访问方法
 * visit 方法 由 element 决定调用的类型
 * Visitor 实现类决定场景维度
 */
public interface Visitor {
    /**
     * 访问普通对象
     * @param element
     */
    void visit(CommenElement element);

    /**
     * 访问管理对象
     * @param element
     */
    void visit(MangerElement element);
}
