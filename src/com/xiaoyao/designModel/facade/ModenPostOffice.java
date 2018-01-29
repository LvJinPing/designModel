package com.xiaoyao.designModel.facade;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-29
 * 门面类，用于提供给客户的调用。 提供各种服务
 */
public interface ModenPostOffice {
    /**
     * 门面提供的寄信服务
     * @param context 文本
     * @param address 地址
     */
    void sendLetter(String context,String address);
}
