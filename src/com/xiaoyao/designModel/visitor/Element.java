package com.xiaoyao.designModel.visitor;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-30
 * 抽象的被访问者，提供共有参数和方法
 * 并抽象出接受访问的抽象方法
 */
public abstract class Element  {
    private String name ;
    private String age;
    private int salary;

    public Element() {
    }

    /**
     * 提供被观察的实现
     * @param visitor
     */
    public abstract void accept(Visitor visitor);


    //===================get/set==============================
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary=" + salary +
                '}';
    }
}
