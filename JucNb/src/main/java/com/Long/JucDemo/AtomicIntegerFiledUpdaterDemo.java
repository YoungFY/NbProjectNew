package com.Long.JucDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2022/1/12
 * @Copyright: Copyright(c)2022 RedaFlight.com All Rights Reserved
 */
public class AtomicIntegerFiledUpdaterDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        for (int i = 0; i < 10; i++) {
            int nameI = i;
            new Thread(() -> {
                account.transferMoney(account);
            }, "name-" + nameI).start();
        }
        TimeUnit.SECONDS.sleep(1);

        System.out.println(account.money);


    }
}
