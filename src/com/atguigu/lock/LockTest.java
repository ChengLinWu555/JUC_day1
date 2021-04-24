package com.atguigu.lock;

import javax.xml.transform.TransformerFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 我是你爹
 */
class Sub{
    int number = 30;
    Lock lock = new ReentrantLock();
    public void setNumber(){
        lock.lock();
        try {
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"卖出第"+(number--)+"张,剩余票数="+number);
            }
        }finally {
            lock.unlock();
        }

    }
}
public class LockTest {
    public static void main(String[] args) {
        Sub sub = new Sub();
        new Thread(() ->{ for (int i = 1; i <= 31; i++) sub.setNumber();},"t1").start();
        new Thread(() ->{ for (int i = 1; i <= 31; i++) sub.setNumber();},"t2").start();
        new Thread(() ->{ for (int i = 1; i <= 31; i++) sub.setNumber();},"t3").start();

    }
}
