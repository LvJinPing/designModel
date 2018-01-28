package com.xiaoyao.designModel.adapter.adaptee;

/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-28
 */
public class Adaptee1 implements Adaptee {
    @Override
    public int isEndWithSomeStr(String targetStr, String endWith) {
        boolean flag = false;
        if (targetStr != null && "" != targetStr && endWith != null && "" != endWith) {
            flag =  targetStr.endsWith("A");
        }
        return flag ? 1 : 0;
    }
}
