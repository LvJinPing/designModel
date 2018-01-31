package com.xiaoyao.designModel.flyWeight;

import java.util.HashMap;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-31
 * 享元工厂，负责创建对象
 */
public class FlyweightFactory {
    private static HashMap<String,FlyWeight> poll = new HashMap<>();
    // 线程安全问题不容忽视。
    public static FlyWeight getFlyWeight(String extrinsic){
        FlyWeight f = null;

        if (poll.containsKey(extrinsic)){
            // 存在则直接从池中取
            f = poll.get(extrinsic);
        }else {
            f = new ConcreteFlyweight1(extrinsic);
            poll.put(extrinsic,f);
        }
        return f;
    }
}
