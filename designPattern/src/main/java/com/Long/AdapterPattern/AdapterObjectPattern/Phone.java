package com.Long.AdapterPattern.AdapterObjectPattern;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/28
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class Phone {
    public void charging(Voltage5V voltage5V) {
        int i = voltage5V.outPut5V();
        if (i == 5) {
            System.out.println("电压为5V 可以充电~~~");
        } else {
            System.out.println("电压不适配~~~~");
        }
    }
}
