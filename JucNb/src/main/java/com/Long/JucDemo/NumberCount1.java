package com.Long.JucDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2022/1/11
 * @Copyright: Copyright(c)2022 RedaFlight.com All Rights Reserved
 */
public class NumberCount1 {


    static AtomicInteger atomicInteger = new AtomicInteger(0);
    Integer nums;


    public void addcount() {
        atomicInteger.incrementAndGet();
    }


    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }
}
