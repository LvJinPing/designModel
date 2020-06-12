package com.xiaoyao.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljp
 * @version 1.0
 * @since 2020-06-11
 * 排序
 */
public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        List<Integer> nums = new ArrayList<>();
        nums.add(3);nums.add(2);nums.add(5);nums.add(3);nums.add(99);nums.add(100);nums.add(88);
        // 冒泡
//        System.out.println(sort.bubbling(nums));
        //选择
//        System.out.println(sort.choose(nums));
        // 归并排序

        //插入排序  适合链表，链表增删块
        //算法题1
//        System.out.println(sort.reSortStr("Keep calm and code on"));
        //leetCode 1452. 收藏清单
        List<List<String>> datas = new ArrayList<>();
        List<String> d1 = new ArrayList<>();d1.add("leetcode");d1.add("google");d1.add("facebook");
        List<String> d2 = new ArrayList<>();d2.add("microsoft");d2.add("google");
        List<String> d3 = new ArrayList<>();d3.add("facebook");d3.add("google");
        List<String> d4 = new ArrayList<>();d4.add("google");
        List<String> d5 = new ArrayList<>();d5.add("amazon");
        datas.add(d1);datas.add(d2);datas.add(d3);datas.add(d4);datas.add(d5);
        System.out.println(sort.peopleIndexes(datas));

    }

    /**
     * 冒泡 倒叙排，每次跟相邻的比较大小，交换位置。 大小相同为位置不会交换
     * 外层循环控制次数，内层循环控制比较次数
     * 第一次 索引 0 与 1 比较 =》 1 与 2 比较 =》 2与3
     * 第二次 索引 0与 1 ，1 与2  (3已经是最大/最小的值了，不需要比较。)
     * 特点：1. 固定了最后一位
     *      2. 大小相同顺序不会交换
     */
    public List<Integer> bubbling(List<Integer> datas){
        int size = datas.size();
        for (int i = 0; i < size -1; i++) {
            for (int j = 0; j < size -i -1; j++) {
                if (datas.get(j)<datas.get(j+1)){
                    // 交换位置
                    Integer temp = datas.get(j);
                    datas.set(j,datas.get(j+1));
                    datas.set(j+1,temp);
                }
            }

        }
        return datas;
    }

    /**
     * 选择 捯排序 每次跟指定位置的数据比较大小，交换位置
     * 特点 :大小相同的位置存在交换的可能（因为是固定位去交换）
     *      固定了首位
     * 外层循环控制次数，内层循环控制比较次数
     * 1： 0》1，0》2，0》3
     * 2：1》2，1》3
     */
    public List<Integer> choose(List<Integer> datas){
        int size = datas.size();
        // i 控制比对位置
        for (int i = 0; i < size -1; i++) {
            // j 控制比对指针
            for (int j = i+1; j < size; j++) {
                if (datas.get(i)<datas.get(j)){
                    // 交换位置
                    Integer temp = datas.get(i);
                    datas.set(i,datas.get(j));
                    datas.set(j,temp);
                }
            }
        }

        return datas;
    }

    /**
     *     「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
     *
     *     1. 句子的首字母大写,其他字母替换
     *     2. text 中的每个单词都用单个空格分隔。
     *     3. 如果两个单词的长度相同，则保留其在原句子中的相对顺序     (因为原顺序不能改变，所以选择不合适。冒泡是可以的，插入排序是否更好)
     *     4. 长度升序
     *
     *输入：text = "Keep calm and code on"
     * 输出："On and keep calm code"
     * 直接 size 比较（直接选择排序比较方便）
     *
     * 其他方式：1.归并排序  2.直接将数据放入对应下标的数组中。需要创建一个无穷大数组，有风险
     */
    public String reSortStr(String str){
        if (str == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] keys = str.split(" ");
        int length = keys.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length -i -1 ; j++) {
                if (keys[j].length() > keys[j+1].length()){
                    String temp = keys[j];
                    keys[j] = keys[j+1];
                    keys[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < keys.length; i++) {
            String sot = keys[i];
            String head = sot.substring(0, 1);
            String tail = sot.substring(1, sot.length());

            if (i == 0){
                keys[i] = head.toUpperCase() + tail;
            }else {
                keys[i] = head.toLowerCase() + tail;
            }
            if (i == length -1){
                sb.append(keys[i]);
            }else {
                sb.append(keys[i]).append(" ");
            }
        }

        return sb.toString();
    }

    /**
     * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
     * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。(即找出一个子数组，不是其他任何数组的子集（任何数组取交集都不能取出来）)
     *  下标顺序还不能动
     *其他说明
     *  1 <= favoriteCompanies.length <= 100
     * 1 <= favoriteCompanies[i].length <= 500
     * 1 <= favoriteCompanies[i][j].length <= 20
     * favoriteCompanies[i] 中的所有字符串 各不相同 。
     * 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
     * 所有字符串仅包含小写英文字母。
     *
     * 思路：1.数据量最大的肯定不会是子集 数据量小的需要与所有相等的和大的比较。 （根据数据长度放入index 的数组中）
     * 2.先按容量降序排序放入另外一个有序数组中（2重for一次）
     * 3 需要逐个集合比较 二维数组结构
     * 4.还需要记录原集合下标
     *
     * @param favoriteCompanies
     * @return
     */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> rData  = new ArrayList<>();
        // 根据算法避免下标越界必须保证size 足够大，只适合小数据量这么处理
        // 此次可以用map key为长度，value 是集合。 如果可以利用jdk 的方式是方便很多的
        List<List<String>>[] lenInx = new List[22];

        //将数据排序放入数组   index 为数组长度
        for (List<String> fc : favoriteCompanies) {
            int size = fc.size();
            List<List<String>> inxD =lenInx[size];
            if (inxD == null) {
                inxD = new ArrayList<>();
                lenInx[size] = inxD;
            }
            inxD.add(fc);
        }
        // 根据长度循环取
        for (int j = 0;j< favoriteCompanies.size();j++) {
            List<String> fc = favoriteCompanies.get(j);
            int size = fc.size();
            int wForTime = 0;
            for (int i = size+1; i < lenInx.length; i++) {
                List<List<String>> gtData = lenInx[i];
                if (gtData == null) {
                    wForTime ++;
                    continue;
                }
                //forTime 只是用于消息传递 以及避免最后一次包含的尴尬
                int forTime = 0;
                for (List<String> stringList : gtData) {
                    // 这里需要我用算法解决吗？  那就更复杂了  已经3重for 了。 其实底层也是for  还有2层 5层
                    boolean b = stringList.containsAll(fc);
                    if (b){
                        break;
                    }
                    forTime ++;
                }
                // > 则存在包含数据
                if (gtData.size() > forTime){
                    break;
                }
                wForTime ++;
            }
            // 如果没有循环完返回了，说明是别人子集 （实际循环次数==理论循环次数）
            if ((lenInx.length - size-1) == wForTime ){
                rData.add(j);
            }
        }


        return rData;
    }
}
