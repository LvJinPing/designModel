package com.xiaoyao.designModel.decorate.decorate;

import com.xiaoyao.designModel.decorate.SchooleReport;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-25
 */
public class HighScoreDecorate extends Decorate {

    public HighScoreDecorate(SchooleReport sr){
        super(sr);
    }

    private void reporteHignScore(){
        System.out.println("最高成绩是 :3 分");
    }
    @Override
    public void reporte(){
        this.reporteHignScore();
        super.reporte();
    }
}
