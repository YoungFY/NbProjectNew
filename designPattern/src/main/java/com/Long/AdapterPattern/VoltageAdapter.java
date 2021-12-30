package com.Long.AdapterPattern;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/28
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int outPut5V() {
        int dest = 220 / 44;
        return dest;
    }
}
