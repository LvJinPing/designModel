package com.xiaoyao.designModel.visitor;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-30
 * 普通员工
 */
public class CommenElement extends Element{
    private String job;
    public CommenElement(){
        super();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return  super.toString() +  "CommenElement{" +
                "job='" + job + '\'' +
                '}'  ;
    }
}
