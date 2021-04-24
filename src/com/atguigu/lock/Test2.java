package com.atguigu.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 我是你爹
 * 判断、干活、通知
 */
class Test{
    int number = 0;

    public synchronized void test1() throws InterruptedException {
        if (number != 0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notify();
    }
    public synchronized void test2() throws InterruptedException {
        if (number == 0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notify();
    }
}
public class Test2 {
    public static void main(String[] args) {
        Test test = new Test();

        new Thread(() -> { for (int i = 1; i <= 10; i++) {
            try {
                test.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"A").start();
        new Thread(() -> { for (int i = 1; i <= 10; i++) {
            try {
                test.test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"B").start();
    }
}
