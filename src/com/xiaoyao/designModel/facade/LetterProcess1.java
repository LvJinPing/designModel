package com.xiaoyao.designModel.facade;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-29
 */
public class LetterProcess1 implements LetterProcessService {
    @Override
    public void writeContext(String context) {
        System.out.println("信件内容 :   "+ context);
    }

    @Override
    public void writeEnvelop(String address) {
        System.out.println("设置收件地址 :   "+ address);
    }

    @Override
    public void letterInoto() {
        System.out.println("把信装好 :   ");
    }

    @Override
    public void send() {
        System.out.println("寄走 :   ");
    }
}
