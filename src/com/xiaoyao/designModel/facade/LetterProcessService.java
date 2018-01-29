package com.xiaoyao.designModel.facade;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-29
 * 业务层接口，负责提供信件相关基本方法
 *
 */
public interface LetterProcessService {
    /**
     * 设置信件内容
     * @param context 信件内容
     */
    void  writeContext(String context);

    /**
     * 设置收件地址
     * @param address
     */
    void writeEnvelop(String address);

    /**
     * 装信
     */
    void letterInoto();

    /**
     * 邮寄
     */
    void send();

}
