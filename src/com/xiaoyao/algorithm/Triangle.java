package com.xiaoyao.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljp
 * @version 1.0
 * @since 2020-06-10
 * 三角形相关
 */
public class Triangle {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.PascalsTriangle(5);
    }

    /**
     * 杨辉三角
     * @param num 非负整数
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     * 总结：这种有行，列的通常是有两层嵌套循环
     */
    public void PascalsTriangle(int num){
        //思路：1. num = 外层数组个数，2. 中间元素= 上层相邻索引元素相加 3.需要处理的都是0<index <= i的数据
        List<List<Integer>> out = new ArrayList<>(num);
        //控制行
        for (int i = 0; i < num; i++) {
            List<Integer> list = new ArrayList<>();
            out.add(list);
            // 控制列
            for (int j = 0; j < i + 1; j++) {
                if (0 < j && j < i){
                    List<Integer> last = out.get(i-1);
                    list.add(last.get(j-1)+last.get(j));
                }else {
                    list.add(1);
                }
            }

        }
        System.out.println(out);

    }

}
