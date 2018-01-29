package com.xiaoyao.designModel.component;

import com.sun.scenario.effect.Crop;

import java.util.List;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-29
 * 树形结构在实际项目中通常通过 数据库存储起来。并不需要用到组合模式。  除了在一些算法中
 * 树形结构(组合模式)分为 安全模式和透明模式
 *      安全模式:  Branch 与 Leafs 是分开的。通过 instanceof 判断是什么节点
 *      透明模式:  Branch 与 Leafs 是一个实现类。通过getChildren 判断是否有子节点来确认是否进行遍历
 */
public class Client {
    public static void main(String[] args) {
        // 树形结构的遍历

    }
    // 树形结构的遍历
    // 递归循环遍历
    private void listCorps(Branch root){
        List<Corp> sub = root.getSub();
        for (Corp corp : sub) {
            if (corp instanceof Branch) {
                corp.getInfo();
                this.listCorps((Branch) corp);
            }
            if (corp instanceof Leafs) {
                corp.getInfo();
            }
        }

    }
}
