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
        nums.add(5);nums.add(11);nums.add(7);nums.add(6);nums.add(20);nums.add(15);
        /*// 冒泡
        System.out.println(sort.bubbling(nums));*/
        /*//选择
        System.out.println(sort.choose(nums));*/
        // 归并排序

        // 快速排序，采用分治法
//        sort.fastSort(nums,0,nums.size()-1);
        // 堆排序
        int[] a = new int[]{1,3,2,4,5,6,7};
        sort.sort(a );
        System.out.println(a);
//        sort.heapSort(a);
//        System.out.println(Arrays.asList(a));
        //二分查找
//        System.out.println(sort.binarySearchFor(a,4));

//        System.out.println(nums);
        //插入排序  适合链表，链表增删块
        //算法题1
//        System.out.println(sort.reSortStr("Keep calm and code on"));
      /*  //leetCode 1452. 收藏清单
        List<List<String>> datas = new ArrayList<>();
        List<String> d1 = new ArrayList<>();d1.add("leetcode");d1.add("google");d1.add("facebook");
        List<String> d2 = new ArrayList<>();d2.add("microsoft");d2.add("google");
        List<String> d3 = new ArrayList<>();d3.add("facebook");d3.add("google");
        List<String> d4 = new ArrayList<>();d4.add("google");
        List<String> d5 = new ArrayList<>();d5.add("amazon");
        datas.add(d1);datas.add(d2);datas.add(d3);datas.add(d4);datas.add(d5);
        System.out.println(sort.peopleIndexes(datas));
*/

    }



    /**
     * 二分查找-递归
     * @param datas
     * @param key
     * @return
     */
    public int binarySearchRecursive(int[] datas,int key,int low ,int hight){
        if(low > hight){
            return  -1;
        }
        int mid = (low+hight)/2;
        if(datas[mid] < key){
            return binarySearchRecursive(datas,key,mid+1,hight);
        }else if(datas[mid]> key){
            return binarySearchRecursive(datas,key,low,mid-1);
        }else {
            return  mid;
        }
    }
    /**
     * 二分查找 迭代法
     * @param datas
     * @param key
     * @return
     */
    public int binarySearchFor(int[] datas,int key){
        int low = 0;
        int hight = datas.length -1;
        if(datas[0] >key || datas[hight]<key ||hight<low){
            return -1;
        }
        while (low <= hight){
            int mid = (hight+low);
            // 往后
            if(datas[mid]<key){
                low = mid+1;
            }
            // 往前
            else if (datas[mid]>key){
                hight = mid-1;
            }else {
                return mid;
            }
        }
        return  -1;
    }



    /**
     * 堆排序实现
     * @param datas
     * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。
     * 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
     */
    public void heapSort(int[] datas){
        // 因为末尾节点的父节点 = ((length-1)-1)/2 推出最后的父节点为  length/2-1
        for(int i=0 ; i<=datas.length/2-1;i++){
            buildHeap(datas,i,datas.length);
        }
        // 需要重下往上找 作 shiftUp 操作。i=0 i++ 的操作堆顶不是最大值
        for(int i=datas.length/2-1;i>=0;i--){
            buildHeap(datas,i,datas.length);
        }
        // 交换排序
        for(int i =datas.length-1;i>=0;i--){
            int temp = datas[i];
            datas[i] = datas[0];
            datas[0]=temp;
            buildHeap(datas,0,i);
        }

        // jdk 版堆 利用优先队列实现, n1-n2这是一个小根堆。。。升序排列的 (n2-n1是一个大根堆)
     /*   PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->n1-n2);
        for (int data : datas) {
            heap.add(data);
        }
        for (int i = 0; i < datas.length; i++) {
            datas[i]= heap.poll();
        }*/
    }

    /**
     * 针对于 i 节点
     * i 的父节点为(i-1)/2
     * i 的两个子节点 (2i+1 和 2i+2)；
     * 构建堆，根据堆排序思想，升序构建大顶堆，降序构建小顶堆。
     * 构建思路： 从深度k-1 处，一层一层往上找。先把每个深度遍历完成。
     * @param datas 构建堆的数组
     * @param i 从第几个索引开始构建。当前父节点
     * @param length  需要构建的长度  （大根放到末尾后不参与后续构建）
     */
    private void  buildHeap(int[] datas,int i,int length){
        int temp = datas[i];
        for(int j = i*2+1; j< length;j=j*2+1){
            // j 取左右节点中大的一个
            if (j + 1 < length && datas[j] < datas[j+1]) {
                j++;
            }
            if(datas[j]> temp){
                // 保留交换后 j 的索引。 后续直接将temp 赋值给i；
                datas[i]=datas[j];
                i = j;
            }else {
                // 因为从底层深度往上，所以上层深度选择排序时，遇到小的肯定时排过序的，直接返回即可
                break;
            }
        }
        datas[i]=temp;
    }

    public void sort(int[] datas){
        for (int i = 0; i < datas.length; i++) {
            for (int j = i+1; j < datas.length; j++) {
                if(datas[i] > datas[j]){
                    int temp = datas[j];
                    datas[j] = datas[i];
                    datas[i] = temp;
                }
            }
        }
    }
    /**
     * 快速排序，采用分治思想。
     * 1. 取一个标志位（从第一个开始取），比标志位大的放右边，比标志位小的放左边（正排序）
     * 2. 递归比较大小
     * 3. 归并结果
     * @param datas 待排序数组/集合
     * @param begin 循环开始位置
     * @param lastIndex 循环结束位置
     * @return
     */
    public void fastSort(List<Integer> datas,int begin,int lastIndex){
        // 递归结束点判断，以及避免下标越界
        if (lastIndex < begin){
            return;
        }
        // 选取标量
        int scalar = datas.get(begin);
        // 循环起点/终点赋值 因为后续会用到入参，不能变更
        int lower = begin;
        int highter = lastIndex;
        //从两头开始取值（highter--，lower ++）分别与标量进行比较。取第一个满足条件的值，设置在标量左右
        while (lower<highter){
            // ++++ 标量选取的左端点，先从右往左找小值，不然最后会丢数据。
            // a.右侧小于标量时结束循环，否则继续寻找。当前highter等待交换位置到左侧
            while (lower < highter &&   datas.get(highter)> scalar){
                highter --;
            }
            datas.set(lower,datas.get(highter));
            // b.左侧大于标量时结束循环，当前lower等待交换位置到右侧 (若没有将== 包含进判断里面会造成死循环，判断必须闭环)
            while (lower < highter &&  datas.get(lower)<=scalar ){
                lower++;
            }
            datas.set(highter,datas.get(lower));

        }
        //将标量替换左右相遇值的位置
        datas.set(lower,scalar);
        //左边拆分
        fastSort(datas,begin,lower-1);
        //右边拆分
        fastSort(datas,lower+1,lastIndex);
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
