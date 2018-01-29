package com.xiaoyao.designModel.component;

/**
 * 树形结构抽象类。
 * demo ，表述公司员工的层级关系
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-28
 */
public abstract class Corp {
    private String name = "";
    private String position = "";
    private int salary = 0;
    public Corp(String name ,String position , int salary){
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    /**
     * 获取当前员工的描叙信息
     */
    public abstract void getInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
