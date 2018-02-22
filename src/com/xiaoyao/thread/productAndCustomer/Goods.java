package com.xiaoyao.thread.productAndCustomer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-22
 * 产品类。供生产者消费者使用
 */
public class Goods {
    /**
     * 最大数量
     */
    private   final int MAX_GOOD = 2;
    /**
     * 最小数量
     */
    private  final int MIX_GOOD = 0;
    /**
     * 当前数量
     */
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 进货
     */
    public void create(){
        try{
            lock.lock();
            //这里如果用 if{wait()}else{notifyAll()} 会存在 死锁 的情况
            // 如果 if｛wari()｝,notifyAll() 存在虚假唤醒的情况
            // 所以需要将 条件放在循环中 而不是 if 中。
            while (count >= this.MAX_GOOD){
                System.out.println("商品已满");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println("增加商品，总数"+ count + "件");
            condition.signalAll();
        }finally{
            lock.unlock();
        }


    }
    /**
     * 出货
     */
    public void sale(){
        try{
            lock.lock();
            while (count <= this.MIX_GOOD){
                System.out.println("库存不足，等待进货");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println("减少商品，总数"+ count + "件");
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }


}
