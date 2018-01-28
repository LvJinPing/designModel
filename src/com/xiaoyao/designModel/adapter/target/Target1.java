package com.xiaoyao.designModel.adapter.target;

/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-28
 */
public class Target1 implements Target {
    @Override
    public boolean isEndWithA(String a) {
        boolean flag = false;
        if (a != null && "" != a) {
           flag =  a.endsWith("A");
        }
        return flag;
    }
}
