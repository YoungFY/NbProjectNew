package com.Long.AbstractFactory;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/24
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class OrderPizza {
    AbstractFactory abstractFactory;
    public OrderPizza(AbstractFactory abstractFactory,String orderType) {
        this.abstractFactory=abstractFactory;
        abstractFactory.createPizza(orderType);
    }
}
