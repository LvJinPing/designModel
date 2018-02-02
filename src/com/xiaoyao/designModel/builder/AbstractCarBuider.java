package com.xiaoyao.designModel.builder;

import java.util.List;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 */
public abstract class AbstractCarBuider {
    /**
     * 设置执行顺序
     * @param sequence 顺序
     */
    public abstract void setSequence(List<String> sequence);

    /**
     * 设置模型
     */
   public  abstract AbstractCarModel getCarModel();
}
