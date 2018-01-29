package com.xiaoyao.designModel.decorate.decorate;

import com.xiaoyao.designModel.decorate.AbstractSchooleReport;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-25
 */
public class HighScoreDecorate extends AbstractDecorate {

    public HighScoreDecorate(AbstractSchooleReport sr){
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
