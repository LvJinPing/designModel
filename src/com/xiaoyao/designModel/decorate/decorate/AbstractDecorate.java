package com.xiaoyao.designModel.decorate.decorate;

import com.xiaoyao.designModel.decorate.AbstractSchooleReport;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-25
 * 装饰模式
 * 装饰抽象类。 提供基本方法
 */
public abstract class AbstractDecorate extends AbstractSchooleReport {
    private AbstractSchooleReport sr;

    /**
     * 只提供有参构造器。强制要求子类调用
     * @param sr
     */
    public AbstractDecorate(AbstractSchooleReport sr){
        this.sr = sr;
    }
    @Override
    public  void reporte(){
        this.sr.reporte();
    };
    @Override
    public  void sign(String name){
        this.sr.sign(name);
    };
}
