package com.xiaoyao.designModel.adapter.target.adapter;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import com.xiaoyao.designModel.adapter.adaptee.Adaptee;
import com.xiaoyao.designModel.adapter.target.Target;

/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-28
 */
public class Adapter implements Target  {
    private Adaptee tee;
    public Adapter(Adaptee tee){
        this.tee = tee;
    }
    @Override
    public boolean isEndWithA(String a) {
        int i = tee.isEndWithSomeStr(a,"A");
        return i == 1 ? true : false;
    }
}
/*  如果 Adaptee 是一个类
public class Adapter extends , Adaptee implements Target   {

    @Override
    public boolean isEndWithA(String a) {
        int i = supper.isEndWithSomeStr(a,"A");
        return i == 1 ? true : false;
    }
}*/