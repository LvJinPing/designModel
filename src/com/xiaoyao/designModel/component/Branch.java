package com.xiaoyao.designModel.component;

import java.util.ArrayList;
import java.util.List;

/**
 * 存在分支的节点
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-29
 */
public class Branch extends Corp{
    private List<Corp> corps = new ArrayList<>();

    public Branch(String name, String position, int salary) {
        super(name, position, salary);
    }

    /**
     * 简单方法不要计较细节
     * @param sub
     */
    public void addSubCorp(Corp sub){
        corps.add(sub);
    }
    public void removeSubCorp(Corp sub){
        corps.remove(sub);
    }
    public List<Corp> getSub(){
        return this.corps;
    }
    @Override
    public void getInfo() {

    }
}
