package com.xiaoyao.designModel.visitor;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-30
 */
public class MangerElement extends Element {
    // 业绩
    private String performance;

    public MangerElement() {}

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public String toString() {
        return super.toString() + "MangerElement{" +
                "performance='" + performance + '\'' +
                '}';
    }
}
