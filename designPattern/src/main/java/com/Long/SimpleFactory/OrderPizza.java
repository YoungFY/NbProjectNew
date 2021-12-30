package com.Long.SimpleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Title: 订购披萨类
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/21
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class OrderPizza {

    /**
     * //定义一个简单工厂
     */
    private SimplePizzaFactory simplePizzaFactory=new SimplePizzaFactory();
    Pizza pizza = null;


    public void setFactory() throws IOException {
        String orderType = "";
        //设置简单工厂对象
        do {
            orderType = getType();
            Pizza pizza = this.simplePizzaFactory.createPizza(orderType);
            //输出Pizza
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败！");
                break;
            }


        } while (true);
    }

    private String getType() throws IOException {
        InputStream in;
        BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("种类名称:");
        String s = strIn.readLine();
        return s;
    }

}
