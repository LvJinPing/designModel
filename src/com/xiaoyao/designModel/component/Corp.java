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
}
