package com.xiaoyao.algorithm;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author ljp
 * @version 1.0
 * @since 2020-07-11
 */
public class TestA {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        String s3 = "a";
        String s4 = "ab";
        String s5 = s3 + "b";
        System.out.println(s5 == s4);
        TestA testA = new TestA();
        /*System.out.println(Long.MAX_VALUE);
        System.out.println(Math.pow(2,10));
        System.out.println(0 > (Integer.MIN_VALUE/10*-1));
        System.out.println(testA.myAtoi("-91283472332"));*/
//        System.out.println(testA.trailingZeroes((13)));
//        System.out.println(testA.topKFrequent(new int[]{1,1,2,2,3,4},2));
      /*  ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(1);
        testA.mergeTwoLists(l1,l2);*/
     /* int[] a= new int[]{5};
        System.out.println(testA.searchRange(a,0));*/
//        System.out.println(testA.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
    // 堆操作(需要从后往前) 分大根堆和小跟堆。 这里演示大根堆
    public  void heap(int[] a,int last, int index){
        int temp = a[index];
        for(int i = index; i<= last ; i = (2* index) +1){

        }

    }



    public int lengthOfLIS(int[] nums) {

        for (int i = 1; i < 4; ++i) {
            System.out.println(i);
            System.out.println(i);
        }

        if(nums.length <2){
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int ans =0;
        dp[0] = 1;
        for(int i =1; i< nums.length; i++){
            // 其实可以直接简化的
            dp[i] = 1;
            for(int j =i-1; j >= 0 ; j--){
                if(j+1< dp[i]){
                    break;
                }
                if(nums[j] < nums[i]){
                    dp[i]= Math.max(dp[j]+1,dp[i]);
                }
            }

            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int hight = nums.length-1;
        boolean find = false;
        int lowI =-1;
        int hightI =-1;
        // 进行2次二分，一次找大值，一次找小值
        while(low <= hight){
            int mid = (low+hight)/2;
            if( nums[mid] < target){
                low = mid +1;
            }else if(nums[mid] > target){
                hight = mid -1;
            }else{
                lowI = mid;
                // 继续往前找
                hight = mid -1;
            }
        }

        // 进行2次二分，一次找大值，一次找小值
        low = lowI;
        hight = nums.length-1;
        while(low <= hight){
            int mid = (low+hight)/2;
            if( nums[mid] < target){
                low = mid +1;
            }else if(nums[mid] > target){
                hight = mid -1;
            }else{
                hightI = mid;
                // 继续往前找
                low = mid +1;
            }
        }

        return new int[]{lowI,hightI};

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 ==null ||l2 == null){
            return l1 == null? l2:l1;
        }
        ListNode newL = null;
        ListNode newLH = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1 != null || temp2 != null){
            ListNode n = null;
            if(temp1 != null && temp2 !=null){
                if(temp1.val<temp2.val){
                    n = new ListNode(temp1.val);
                    temp1 = temp1.next;
                }else{
                    n = new ListNode(temp2.val);
                    temp2 = temp2.next;
                }

            }else{
                if(temp1!= null){
                    n = new ListNode(temp1.val);
                    temp1 = temp1.next;
                }else{
                    n = new ListNode(temp2.val);
                    temp2 = temp2.next;
                }
            }
            if(newLH == null){
                newLH= n;
                newL =n;
            }else{
                newL.next =n;
            }

        }
        return newLH;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
             map.put(num,map.get(num)==null? 1: map.get(num)+1);
//            map.put(num,map.getOrDefault(num, 0) + 1);
        }
        // 队列中放入数组元素，且以map中count的大小排序
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for(int i: map.keySet()){
            heap.add(i);
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=heap.poll();
        }
        return ans;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> m = new HashMap<>();
        m.put(')','(');
        m.put(']','[');
        m.put('}','{');
        for(int i=0;i< s.length();i++){
            //1.判断是左还是右 //2.1 左括号，压入栈
            if('('== s.charAt(i)|| '{'==s.charAt(i) ||'['==s.charAt(i)){
                stack.push(s.charAt(i));
            }
            if(')'== s.charAt(i)|| '}'==s.charAt(i) ||']'==s.charAt(i)){
                if(stack.isEmpty() || stack.peek() != s.charAt(i)){
                    return false;
                }else{
                    stack.pop();
                }
            }
            //2.2 右括号，判断上一个括号是否对应的左括号。是 弹出栈
            //3.1          == 不是，返回false;
        }
        return true;
    }
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);// 升序排列
        int count =0;
        for(int i=1;i<A.length;i++){
            //需要找相同 找相同
            boolean flag = false;
            int a =A[i];
            do{
                if(flag){
                    count++;
                    a ++;
                    A[i]= a;
                }
                flag = false;
                for(int j=0;j<A.length;j++){
                    if(j==i){
                        continue;
                    }
                    if(A[i]== A[j]){
                        flag=true; // 存在相同
                        break;
                    }
                }
            }while(flag);

        }
        return count;
    }



    public int trailingZeroes(int n) {

        // Calculate n!
        BigInteger nFactorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            //阶乘
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }

        // Count how many 0's are on the end.
        int zeroCount = 0;
        // 判断 mod 取余数
        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFactorial = nFactorial.divide(BigInteger.TEN);
            zeroCount++;
        }

        return zeroCount;
    }

    int[][] stats = {   {0, 1, 2, 3},
            {3, 3, 2, 3},
            {3, 3, 2, 3},
            {3, 3, 3, 3}
    };
    public int myAtoi(String str) {
        int q =1;
        long ans = 0;
        int state =0;
        for(int i=0;i<str.length();i++){
            state=getStart(state,str.charAt(i));
            // 如果是正负数状态
            if(1== state){
                q = ('+'==str.charAt(i)) ? 1:-1;
            }else if(2 == state){
                int c = Character.getNumericValue(str.charAt(i));
                if(1== q){
                    ans = (ans >Integer.MAX_VALUE/10|| ( ans ==Integer.MAX_VALUE/10 && c >7)) ?Integer.MAX_VALUE: ans*10+c;
                }else {
                    ans = (ans > Integer.MIN_VALUE/10*-1|| ( ans == -Integer.MIN_VALUE/10*-1 && c >8)) ?Integer.MAX_VALUE+1L: ans*10+c;// 这里极端情况会丢失一位
                }

            }else if(3==state){
                break;
            }
        }
        return q*((int)ans);
    }
    private int getStart(int start,char c){
        return stats[start][getCi(c)];
    }
    private int getCi(char c){
        if(' '==c){
            return 0;
        }
        if('+'==c|| '-'==c){
            return 1;
        }
        if(Character.isDigit(c)){
            return 2;
        }
        return 3;
    }
}
