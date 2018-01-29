package com.xiaoyao.designModel.memeto.extend.byclone;

import com.xiaoyao.designModel.memeto.Memeto;

/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-29
 * 通过 clone 的方式实现备份。 可以直接备份整个对象
 *  需要注意 clone 的浅复制
 *
 *  也可以通过 BeanUtils 工具类。将对象属性转成 Map<String ,Object > 的方式备份保存。 （Memeto 中用相应的 Map 属性保存）
 */
public class Boy implements Cloneable {
    private String name;
    private String age;
    // 需要被备份的状态
    private String state;
    public Boy(){}

    /**
     * 保存状态。 备忘录由需要被记录状态的类创建
     */
    public Boy setMemeto(){
        return this.clone();
    }

    /**
     * 恢复保存状态
     */
    public void restartMemeto(Boy boy){
        this.setState(boy.getState());
        this.setAge(boy.getAge());
        this.setName(boy.getName());
    }

    /**
     * 重写 clone 方法
     * @return
     */
    @Override
    protected Boy clone(){
        Boy b = null;
        try {
            b = (Boy)super.clone();
        } catch(Exception e){
            e.printStackTrace();
        }
     return  b;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
