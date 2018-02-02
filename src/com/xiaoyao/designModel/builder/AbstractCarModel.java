package com.xiaoyao.designModel.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * AbstractCarModel 提供基本方法共子类实现。
 * Car run 运行顺序有调用者决定。
 */
public abstract class AbstractCarModel {
    private List<String> sequence = new ArrayList<>();
    protected abstract void start();
    protected abstract  void stop();
    protected abstract void alarm();
    public void run(){
        for (String s : this.sequence) {
            if (s.equals("start")){
                this.start();
            }else if (s.equals("stop")){
                this.stop();
            }else if(s.equals("alarm")){
                this.alarm();
            }
        }
    }

    public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }
}
