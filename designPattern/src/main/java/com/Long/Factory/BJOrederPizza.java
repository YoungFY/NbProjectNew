package com.Long.Factory;

/**
 * @Title: 北京披萨订单类
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/24
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class BJOrederPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza=null;
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
            pizza.bake();
            pizza.box();
            pizza.box();
        }
        if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }
        if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }
}
