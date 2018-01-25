package com.xiaoyao.designModel.decorate;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-25
 * 定义抽象类，提供基本方法
 * 报告成绩 + Fathre 在成绩单上签字
 */
public abstract class SchooleReport {
    /**
     * 汇报成绩
     */
    public abstract void reporte();

    /**
     * 签字
     * @param name
     */
    public abstract void sign(String name);
}
