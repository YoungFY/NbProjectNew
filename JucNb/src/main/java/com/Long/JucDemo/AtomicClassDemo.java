package com.Long.JucDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2022/1/12
 * @Copyright: Copyright(c)2022 RedaFlight.com All Rights Reserved
 */
public class AtomicClassDemo {


    public static void main(String[] args) throws InterruptedException {
        NumberCount1 numberCount1=new NumberCount1();
        CountDownLatch countDownLatch=new CountDownLatch(20);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    numberCount1.addcount();
                }
            });
        }

        Thread.sleep(1000);
        System.out.println(NumberCount1.atomicInteger.get());



    }
}
