package com.Long.AbstractFactory;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/24
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class BJFactory extends AbstractFactory {
    @Override
    Pizza createPizza(String orderType) {
       Pizza pizza=new BJCheessPizza();
       pizza.bake();
       pizza.box();
       pizza.cut();
       return pizza;
    }
}
