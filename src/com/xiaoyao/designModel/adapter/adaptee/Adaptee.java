package com.xiaoyao.designModel.adapter.adaptee;

/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-28
 */
public interface Adaptee {
    /**
     *  判断是否以指定字符串结束
     * @param targetStr 目标字符串
     * @param endWith 结束字符串
     * @return 0 false， 1 true
     */
    int isEndWithSomeStr(String targetStr, String endWith);
}
