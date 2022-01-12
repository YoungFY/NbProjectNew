package com.Long.JucDemo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Title: 根据CAS实现自定义锁
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2022/1/11
 * @Copyright: Copyright(c)2022 RedaFlight.com All Rights Reserved
 */
public class SelfDemoCASLock {


    AtomicReference atomicReference = new AtomicReference();

    /**
     * 解锁
     *
     * @return
     */
    public boolean myUnLock() {
        Thread thread = Thread.currentThread();
        boolean flag = atomicReference.compareAndSet(thread, null);
        System.out.println("解锁成功~~！" + thread.getName());
        return flag;

    }

    /**
     * 加锁
     *
     * @return
     */
    public boolean myLock() {
        Thread thread = Thread.currentThread();
        boolean lock = atomicReference.compareAndSet(null, thread);
        System.out.println("加锁成功~~！" + thread.getName());
        return lock;
    }

    public static void main(String[] args) throws InterruptedException {
        SelfDemoCASLock selfDemoCASLock = new SelfDemoCASLock();
        new Thread(() -> {
            selfDemoCASLock.myLock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            selfDemoCASLock.myUnLock();

        }, "test").start();
        Thread.sleep(1000);
        new Thread(() -> {
            selfDemoCASLock.myLock();
            selfDemoCASLock.myUnLock();
        }, "test2").start();

    }

}
