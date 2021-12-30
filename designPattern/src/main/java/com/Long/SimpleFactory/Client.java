package com.Long.SimpleFactory;

import java.io.IOException;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/21
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class Client {

    public static void main(String[] args) throws IOException {
        OrderPizza orderPizza=new OrderPizza();
        orderPizza.setFactory();
    }
}
