package com.xiaoyao.designModel.decorate;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-25
 */
public class FouthGradeSchoolReport extends SchooleReport {
    @Override
    public void reporte() {
        System.out.println("father 我的成绩是 : 0 分");
    }

    @Override
    public void sign(String name) {
        System.out.println("father :" + name + "   签字确认");
    }
}
