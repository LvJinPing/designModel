package com.xiaoyao.designModel.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-02
 * 封装创建不同模型的公共方法。client 调用更加方便。 业务中需要什么顺序直接加在这里面就可以了
 */
public class Director {
    private List<String> sequence = new ArrayList<>();
    // 可以更加不同的 builder 创建不同的 Director
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();
    public BenzCar getBenSUV(){
        // 不清空可能产生问题
        sequence.clear();
        sequence.add("start");
        sequence.add("alarm");
        benzBuilder.setSequence(sequence);
        return benzBuilder.getCarModel();
    }
    public BenzCar getBenMVP(){
        sequence.clear();
        sequence.add("start");
        sequence.add("stop");
        sequence.add("alarm");
        benzBuilder.setSequence(sequence);
        return benzBuilder.getCarModel();
    }
    public BMWCar getBMWMVP(){
        sequence.clear();
        sequence.add("start");
        sequence.add("alarm");
        sequence.add("stop");

        bmwBuilder.setSequence(sequence);
        return bmwBuilder.getCarModel();
    }
    public BMWCar getBMWSUV(){
        sequence.clear();
        sequence.add("alarm");
        sequence.add("start");
        sequence.add("stop");
        bmwBuilder.setSequence(sequence);
        return bmwBuilder.getCarModel();
    }
}
