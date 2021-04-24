package com.atguigu.lock;

import java.util.concurrent.TimeUnit;

/**
 * 我是你爹
 */
class Phone{

    public  synchronized void sendEmail(){

        System.out.println("-----Email");
    }
    public static synchronized void sendSMS()
    {
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("-----SMS");
    }

}
public class LockTest8 {

    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {phone.sendSMS();},"t1").start();
        new Thread(() -> {phone2.sendEmail();},"t2").start();
        Thread thread = new Thread();
    }

}
