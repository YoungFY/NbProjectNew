package com.Long.AdapterPattern.AdapterObjectPattern;

/**
 * @Title: 适配器模式 以对象的模式进行适配，把需要转换类创建实例的方法进行聚合，
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/28
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }


}
