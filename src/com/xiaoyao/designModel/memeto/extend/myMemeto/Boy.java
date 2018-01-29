package com.xiaoyao.designModel.memeto.extend.myMemeto;


/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-29
 */
public class Boy {
    private String name;
    private String age;
    // 需要被备份的状态
    private String state;
    public Boy(){}

    /**
     * 保存状态。 备忘录由需要被记录状态的类创建
     */
    public IMemeto setMemeto(){
        return new Memeto(this.state);
    }

    /**
     * 恢复保存状态
     */
    public void restartMemeto(IMemeto memeto){
        this.setState(((Memeto)memeto).getState());
    }

    /**
     * 通过内部类 只允许自己访问备忘录
     */
    private class Memeto implements IMemeto{
        private String state;

        private Memeto(String state) {
            this.state = state;
        }

        private String getState() {
            return state;
        }

        private void setState(String state) {
            this.state = state;
        }
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
