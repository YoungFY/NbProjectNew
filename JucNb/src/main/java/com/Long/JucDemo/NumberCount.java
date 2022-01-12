package com.Long.JucDemo;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2022/1/11
 * @Copyright: Copyright(c)2022 RedaFlight.com All Rights Reserved
 */
public class NumberCount {


    volatile Integer nums = 0;



    public  void addcount() {

            nums++;

    }



    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }
}
