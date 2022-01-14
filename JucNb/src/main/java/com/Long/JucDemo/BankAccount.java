package com.Long.JucDemo;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2022/1/12
 * @Copyright: Copyright(c)2022 RedaFlight.com All Rights Reserved
 */
public class BankAccount {
    private String bankName = "ccc";
    public volatile int money = 0;
    //只是局部加锁，通过对象当中,对某一个字段进行加锁
    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(BankAccount.class, "money");

    public void transferMoney(BankAccount account) {
        atomicIntegerFieldUpdater.incrementAndGet(account);
    }


}
