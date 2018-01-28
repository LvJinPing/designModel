package com.xiaoyao.designModel.adapter;

import com.xiaoyao.designModel.adapter.adaptee.Adaptee1;
import com.xiaoyao.designModel.adapter.target.Target;
import com.xiaoyao.designModel.adapter.target.Target1;
import com.xiaoyao.designModel.adapter.target.adapter.Adapter;

/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-28
 */
public class Client {

    public static void main(String[] args) {
        Target t = new Target1();
        t.isEndWithA("absA");
        // 使用适配器时
        Target t1 = new Adapter(new Adaptee1());
        t1.isEndWithA("adf");
    }
}
