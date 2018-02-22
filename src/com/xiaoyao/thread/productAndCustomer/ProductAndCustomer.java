package com.xiaoyao.thread.productAndCustomer;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-02-22
 */
public class ProductAndCustomer {
    public static void main(String[] args) {
        Goods g = new Goods();
        System.out.println("haha");
        Runnable create = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    g.create();
                }
            }
        };
        Runnable customer = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    g.sale();
                }
            }
        };
        new Thread(create,"c1").start();
        new Thread(create,"c2").start();
        new Thread(customer,"p1").start();
        new Thread(customer,"p2").start();
    }
}
