package com.Long.JucDemo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/30
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class Test1 {
    public static List<String> list = Arrays.asList("jd", "tanmao", "pdd", "tamll");

//    public static void main(String[] args) {
//
//        List<String> priceAsync = getPriceAsync(list);
//        priceAsync.forEach(str -> System.out.println(str));
//    }


    public static List<String> getPriceAsync(List<String> mallList) {
//        2f 截取小数后两位
        List<CompletableFuture<String>> collect = mallList.stream().
                map(mall -> CompletableFuture.supplyAsync(() ->
                        String.format(mall + "is %s price is %.2f threadName is %s", mall, calcPrice(mall), Thread.currentThread().getName()))).
                collect(Collectors.toList());
        List<String> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        return collect1;
//                .stream().map(CompletableFuture::join).collect(Collectors.toList());
//        return null;
//        List<CompletableFuture<String>> collect = mallList.stream().
//                map(mall -> CompletableFuture.supplyAsync(() ->
//                        String.format(mall + "is %s price is %.2f threadName is %s", mall, calcPrice(mall), Thread.currentThread().getName()))).
//                collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public static double calcPrice(String productName) {
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }


    @Test
    public void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return 2;

        });

        //当完成的时候
        future.complete(666);
        System.out.println(future.get());
    }

    @Test
    public void test2() {
        CompletableFuture.supplyAsync(() -> {
            return 1 / 0;
        }).thenApply(f -> {
            System.out.println(f);
            return f + 1;
        }).thenApply(f -> {
            System.out.println(f);
            return f + 1;
        }).whenComplete((v, e) -> {
            System.out.println("返回值---" + v);
        }).exceptionally(e -> {
            e.printStackTrace();
            if (e == null) {
                return null;
            } else {
                e.printStackTrace();
                return 0;
            }
        });
    }

    @Test
    public void test3() {
        CompletableFuture.supplyAsync(() -> {
            return 1 / 0;
        }).handleAsync((f, e) -> {
            try {
                if (e.getMessage() != null) {
                    f = 0;
                }
                return f + 1;
            } catch (Exception exception) {
                exception.printStackTrace();
                return 0;
            }
        }).handleAsync((f, e) -> {
            e.printStackTrace();
            System.out.println("handleAsync 1==" + f);
            return f + 1;
        }).whenCompleteAsync((v, e) -> {
            System.out.println("返回值---" + v);
        });
    }

    static LockObject lockA = new LockObject();
    static LockObject lockB = new LockObject();

    @Test
    public void test5() {
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "持有A锁，准备获取B锁！");

                synchronized (lockB) {
                    System.out.println("获取B锁成功");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "持有B锁，准备获取A锁！");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (lockA) {
                    System.out.println("获取A锁成功！");
                }
            }
        }).start();
    }

    @Test
    public void test6() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().isInterrupted());
        }, "aa").start();
    }

    @Test
    public void test7() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("--------i" + i);
            }
            System.out.println("t1 interrupted()---02" + Thread.currentThread().isInterrupted());
        }, "t1");
        t1.start();
        System.out.println("t1 interrupted() 调用之前，t1线程的中断标识默认值---02" + t1.isInterrupted());
        t1.interrupt();
        System.out.println("t1 interrupt()调用之后" + t1.isInterrupted());
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1 interrupt() 调用之后03" + t1.isInterrupted());
    }

    @Test
    public void test8() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("--------i" + i);
            }
            System.out.println("t1 interrupted()---02" + Thread.currentThread().isInterrupted());
        }, "t1");
        t1.start();
        System.out.println("t1 interrupted() 调用之前，t1线程的中断标识默认值---02" + t1.isInterrupted());
        System.out.println("t1 interrupt()调用之后" + t1.isInterrupted());
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1 interrupt() 调用之后03" + t1.isInterrupted());
    }

    @Test
    public void test9() {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程开始come in--");
            LockSupport.park(); //线程被阻塞
            LockSupport.park(); //线程被阻塞
            LockSupport.park(); //线程被阻塞
            System.out.println(Thread.currentThread().getName() + "被唤醒");
        }, "t1");
        t1.start();
//提前发起通知解锁
        new Thread(() -> {
            LockSupport.unpark(t1);  //上限就是1 at most 1 LockSupport.unpark(t1) 只允许有一个
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "发出通知唤醒---");
        }).start();
    }

    /*
     *
     * */
    @Test
    public void test10() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "start");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t" + "被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "通知了");
        }, "t2").start();
    }

    /**
     * 多个线程累加操作
     */
    @Test
    public void test11() throws InterruptedException {
        NumberCount numberCount = new NumberCount();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    numberCount.addcount();
                }
            }, i + "").start();
        }

        Thread.sleep(3000);
        System.out.println(numberCount.getNums());
    }


    public static String test12() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("test");
            try{
                return "sdfasdfasdf";
            }catch (Exception e){
                throw new Exception("test exception");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
            System.out.println(" lock.unlock();");
        }
        return null;
    }

    public static void main(String[] args) {
        test12();

    }

}
