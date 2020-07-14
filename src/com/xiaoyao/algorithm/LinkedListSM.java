package com.xiaoyao.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author ljp
 * @version 1.0
 * @since 2020-07-03
 */
public class LinkedListSM {
    public static void main(String[] args) {
        LinkedListSM lls = new LinkedListSM();
//        System.out.println(lls.headInsert());
//        System.out.println(lls.tailInsert());
//        System.out.println(lls.rotateNow(lls.tailInsert()));
        String[] strings = new String[]{"flower","flow","floght"};
//        System.out.println(lls.longestCommonPrefix(strings));
        System.out.println(lls.twoSplit(strings));

    }
    /**
     * 头插法
     * 每次插入的元素在头部，插入顺序与链表顺序相反
     * @return
     */
    public Link headInsert(){
        Random random = new Random();
        // head 用于保存上次一插入后的头节点，temp 用于交换顺序
        Link head = null;
        for (int i = 0; i < 5; i++) {
            int data = random.nextInt(20);
            System.out.println("数据顺序"+ data);
            Link link = new Link(data);
            link.next = head;
            head = link;

        }

        return head;
    }

    /**
     * 尾插法
     * 每次插入的元素在头部，插入顺序与链表顺序相同
     * @return
     */
    public Link tailInsert(){
        Random random = new Random();
        // head 用于保存上次一插入后的头节点，temp 保存上一次的插入节点
        Link head = null, nowNode = null;
        for (int i = 0; i < 5; i++) {
            int data = random.nextInt(20);
            System.out.println("数据顺序"+ data);
            Link link = new Link(data);
            if (head == null) {
                head = link;
                nowNode = link;
            }else {
                nowNode.next = link;
                nowNode = link;
            }
        }

        return head;
    }

    /**
     * 链表反转,头插法反转==> 将得到一个新链表
     * 1. 保留住头部，遍历后面的节点，插入头节点之前
     * 2 4，3，2，1 =》 3，4，2，1 =》 2，3，4，1 =》 1，2，3，4
     */
    public Link rotateHead(Link a){
        if (a == null) {
            return a;
        }
        // 基准点引用不变
        Link mark = a;
        // 设置头节点基础值
        Link head = null;
        // 中间变量,保存上一次循环的值
        Link temp = null;
        while (mark.next != null){
            // 1. a节点下一个值保存到零时值中
            head = mark.next;
            // 2. temp. next 赋值给 mark.a,移动一位
            mark.next = mark.next.next;
            // 3. 更新新head 的next 节点
            if (temp == null){
                head.next = mark;
            }else {
                head.next = temp;
            }
            // 4. 将当前头节点保存入temp
            temp = head;
        }
        return head;
    }
    /**
     * 链表反转,就地反转 == 》得到原链表
     * 原理步骤   a,b,c,d
     * 1 : a 与 b 交换顺序  => b,a,c,d
     * 2: b,a 与 c 交换顺序 => c,b,a,d
     * 3 : c,b,a 与d 交换顺序=> d,c,b,a
     * a. 不与循环次数相关（没有索引没法计算）
     * b. 始终是a后面第一个节点与前面所有交换
     * c. 链表的交换与数组不同，链表的交换其实是一个插入操作。 如果只有两个节点，可以引入一个头节点进行辅助操作
     */
    public Link rotateNow(Link a){
        if (a == null || a.next == null){
            return a;
        }
        // 引入临时头节点辅助交换操作
        Link l = new Link(-1);
        l.next = a;
        Link pNext = null;
        Link temp ;
        // 链表的遍历都用while ，需要注意
        while (a.next != null){
            // 1. 获取pnext
            pNext = a.next;
            // 2. 将pNext.next 值保存在a后面
            a.next = pNext.next;
            // 3. 将pNext 于a 进行交换(其实是一个插入操作)
            pNext.next = l.next;
            l.next = pNext;
        }
        return l.next;
        // 感觉跟头插法没啥区别啊
    }

    /**
     * 删除倒数第n个节点,并返回头节点
     * @param
     * @param n
     * @return
     */
    public Link removeNthFromEnd(Link head,int n){
// 用hash表保存索引数，一个循环处理
        if(head == null){
            return head;
        }
        Link temp = head;
        int count = 0;
        Map<Integer,Link> m = new HashMap<>();

        while (temp != null){
            m.put(++count,temp);
            temp = temp.next;
        }
        // 删除节点
        if(count >= n){
            Link lastNode = m.get(count-n);
            Link t = m.get(count-n+1);
            lastNode.next = t.next;
        }
        return head;

    }

    // 链表声明
    private class Link{
        int data;
        Link next;


        public Link(int data) {
            this.data =data;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Link{");
            sb.append("data=").append(data);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }

    public String twoSplit(String[] strs){
        if(null == strs || strs.length ==0){
            return "";
        }
        if(strs.length ==1){
            return strs[0];
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        System.out.println(Arrays.asList(strs));
        int hight = strs[0].length();
        int low = 0;
        String ans = strs[0];
        while(low< hight){
            int mid = (hight + low + 1) / 2;
            for(int i=1; i< strs.length;i++){
                if(strs[i].substring(0,mid).equals(ans.substring(0,mid))){
                    // 相等后面二分
                    low = mid;
                }else{
                    // 不相等往前找
                    hight = mid-1;
                }
            }
        }
        System.out.println(low+","+hight);
        return ans.substring(0,low);

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low+","+high);
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
