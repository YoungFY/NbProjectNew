package com.Long.AbstractFactory;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/24
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class Clinet {
    public static void main(String[] args) {
        OrderPizza orderPizza=new OrderPizza(new BJFactory(),"cheess");


    }
}
