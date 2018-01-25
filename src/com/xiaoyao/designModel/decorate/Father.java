package com.xiaoyao.designModel.decorate;

import com.xiaoyao.designModel.decorate.decorate.HighScoreDecorate;
import com.xiaoyao.designModel.decorate.decorate.SortDecorate;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-25
 */
public class Father {
    public static void main(String[] args) {
        SchooleReport sr;
        sr = new FouthGradeSchoolReport();
        sr = new HighScoreDecorate(sr);
        sr = new SortDecorate(sr);
        sr.reporte();
        sr.sign("孤");
        /*  我的排名是 10
            最高成绩是 :3 分
            father 我的成绩是 : 0 分
            father :孤   签字确认*/
    }
}
