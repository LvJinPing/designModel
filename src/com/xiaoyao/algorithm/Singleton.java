package com.xiaoyao.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ljp
 * @version 1.0
 * @since 2020-08-04
 */
public class Singleton {

    private static  volatile Singleton  s = null;

    private Singleton(){}

    public static Singleton getInstance(){

        if (null == s) {
            synchronized (Singleton.class){
                if (s == null) {
                    s = new Singleton();
                }
            }
        }
        return  s;

    }


    public void sort(int[] datas,int start ,int end){
        if(start >= end){
            return;
        }
        int temp = datas[start];
        int left = start;
        int right = end;
        while (left < right){
            while (datas[right] > temp && left < right){
                right--;
            }
            datas[left] = datas[right];
            while (datas[left] <= temp && left < right){
                left ++;
            }
            datas[right] = datas[left];
        }
        datas[left] = temp;
        sort(datas,start,left-1);
        sort(datas,left+1,end);
    }

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
        int[] datas = new int[]{5,11,7,6,20,15,15};
//        instance.sort(datas,0,datas.length-1);
        instance.heapSort(datas);
        for (int i = 0; i < datas.length; i++) {
            System.out.println(datas[i]);

        }
    }

    public int getMin(List<Map<Integer,Integer>> datas){
        if (datas == null || datas.size() ==0) {
            return  -1;
        }

        int min = Integer.MAX_VALUE;
        for (Map<Integer, Integer> data : datas) {
            for (Integer integer : data.keySet()) {
                if(data == null || data.size() == 0){
                    continue;
                }
                ArrayList<Integer> integers = new ArrayList<>(data.keySet());
                integers.sort((a,b) -> a-b);
                min = Math.min(min,integers.get(0));
            }
        }

        return  min;

    }

    public void heapSort(int[] nums){
        // 最后一个父节点 (nums.length - 1 -1)/2
        for (int i = nums.length/2-1; i >=0 ; i--) {
            buildHeap(nums,i,nums.length-1);
        }
        // 排序
        for (int i = 0; i< nums.length; i++){
            // 将头放入尾
            int lastIndex = nums.length -1 -i;
            int temp = nums[0];
            nums[0] = nums[lastIndex];
            nums[lastIndex] = temp;
            // 重新构建堆
            buildHeap(nums,0,lastIndex-1);
        }

    }

    /**
     * 升序构建大根堆
     */
    public void buildHeap(int[] nums ,int index,int lastIndex){
        int temp = nums[index];
        for (int i = 2*index +1; i <= lastIndex; i = 2*i+1) {
          if (i + 1 <= lastIndex && nums[i] < nums[i+1]){
              i = i+1;
          }
          if (nums[i] > temp){
              nums[index] = nums[i];
              index = i;
          }
        }
        nums[index] = temp;
    }


}
