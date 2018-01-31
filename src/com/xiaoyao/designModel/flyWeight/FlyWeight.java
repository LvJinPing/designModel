package com.xiaoyao.designModel.flyWeight;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 * 享元模式抽象类
 */
public abstract class FlyWeight {
    // 内部状态  id 等属于当前对象的特征量。每个对象都不相同
    private String intrinsic;
    //外部状态  final 防止状态被更改
    // 程序开发中，确认只需要一次复制的性设置为 fianl 类型，避免五一的修改倒置逻辑混乱。 特别是 session 级别的常量
    // 外部状态会作为 map 的key 最好是多个对象拥有共同参数   (考试科目 + 考试地点这种东西就是定死了的)
    protected final String Extrinsic;

    public FlyWeight(String extrinsic) {
        Extrinsic = extrinsic;
    }

    /**
     * 业务操作
     */
    public abstract void operate();


    public String getExtrinsic() {
        return Extrinsic;
    }

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
