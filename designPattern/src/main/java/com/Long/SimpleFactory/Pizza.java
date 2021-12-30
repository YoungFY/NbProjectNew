package com.Long.SimpleFactory;

/**
 * @Title: 抽象披萨类 让具体的每一个pizza都继承该类
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/21
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public abstract class Pizza {

    private String name;

    public String getName() {
        return name;
    }
    public abstract void setName(String name);

    public abstract void prepare();

    public abstract void bake();

    public abstract void cut() ;

    public abstract void box();
}
