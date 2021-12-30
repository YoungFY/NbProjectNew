package com.Long.AdapterPattern;

/**
 * @Title: 适配器模式 类适配器
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/28
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }


}
