package com.xiaoyao.designModel.facade;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-29
 */
public class ModenPostOffice1 implements ModenPostOffice {
    private LetterProcessService l = new LetterProcess1();
    private Police p = new Police();

    @Override
    public void sendLetter(String context, String address) {
        l.writeContext(context);
        l.writeEnvelop(address);
        l.letterInoto();
        p.checkLetter();
        l.send();
    }
}
