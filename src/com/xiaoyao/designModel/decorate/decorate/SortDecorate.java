package com.xiaoyao.designModel.decorate.decorate;

import com.xiaoyao.designModel.decorate.SchooleReport;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-25
 */
public class SortDecorate extends Decorate {

    public SortDecorate(SchooleReport sr){
        super(sr);
    }

    /**
     * 装饰类的具体装饰方法。
     */
    private void sort(){
        System.out.println("我的排名是 10 ");
    }
    @Override
    public void reporte(){
        this.sort();
        super.reporte();   // supper.reporte() 调用的实际类型。
    }
}
