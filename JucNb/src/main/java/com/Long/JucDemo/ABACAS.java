package com.Long.JucDemo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Title: 复现ABA问题，以及解决ABA问题
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2022/1/11
 * @Copyright: Copyright(c)2022 RedaFlight.com All Rights Reserved
 */
public class ABACAS {

    public static void main(String[] args) {

//test
    }

    /**
     * 产生ABA问题
     *
     * @throws InterruptedException
     */
    static AtomicInteger atomicInteger = new AtomicInteger(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(100, 1);

    @Test
    public void test1() throws InterruptedException {

        new Thread(() -> {
            boolean b1 = atomicInteger.compareAndSet(100, 200);
            boolean b2 = atomicInteger.compareAndSet(200, 100);
            System.out.println(Thread.currentThread().getName() + "====" + "修改完成！" + b1 + " " + " " + b2);
        }, "test1").start();
        Thread.sleep(1000);
        new Thread(() -> {
            boolean b = atomicInteger.compareAndSet(100, 200);
            System.out.println(Thread.currentThread().getName() + b + "修改成功！");
        }, "test2").start();
    }

    /**
     * ABA问题解决方式,通过版本号机制解决ABA问题
     */
    @Test
    public void test2() {
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "-----默认版本号" + stamp);
            boolean b = atomicStampedReference.compareAndSet(100, 200, atomicStampedReference.getStamp(), stamp + 1);
            System.out.println(Thread.currentThread().getName() + " 1.更新过一次的版本号：" + atomicStampedReference.getStamp() + "是否更新成功！" + b);
            boolean b1 = atomicStampedReference.compareAndSet(200, 100, atomicStampedReference.getStamp(), stamp + 1);
            System.out.println(Thread.currentThread().getName() + " 2.更新过一次的版本号：" + atomicStampedReference.getStamp() + "是否更新成功！" + b1);
        }, "t2").start();
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            boolean b1 = atomicStampedReference.compareAndSet(100, 200, atomicStampedReference.getStamp(), stamp + 1);
            System.out.println("第三次修改的版本号！" + stamp);
            System.out.println(Thread.currentThread().getName() + "----" + stamp + " 是否更新成功！" + b1);
        }, "t3").start();


    }


}
