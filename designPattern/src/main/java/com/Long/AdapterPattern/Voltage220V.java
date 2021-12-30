package com.Long.AdapterPattern;

/**
 * @Title: 被适配类
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/28
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class Voltage220V {

    public int outPut220V() {
        System.out.println("220V电压");
        return 220;
    }
}
