package com.xiaoyao.designModel.memeto.extend.keepDeferentMemeto;

import com.xiaoyao.designModel.memeto.Memeto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyao
 * @version 1.0
 * @email lvjinping_work@outlook.com
 * @since 2018-01-29
 * 保存不同的备忘录。 职责要分开。 管理类负责保存备忘录。 Memeto 负责记录日志
 */
public class Caretaker {
    private Map<String , Memeto> ms = new HashMap<>();

    public Caretaker() {
    }

    public Memeto getM(String key) {
        return ms.get(key);
    }

    /**
     * 可能有具体的业务逻辑处理
     * @param m
     */
    public void setM(String key,Memeto m) {
        this.ms.put(key,m);
    }
}
