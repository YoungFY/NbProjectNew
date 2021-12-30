package com.juc.test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/29
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class TestApplication {

    public static void main(String[] args) {

        System.out.println(ThreadLocalRandom.current().nextLong());
        System.out.println(ThreadLocalRandom.current().nextDouble());




    }
}
