package com.Long.Factory;

/**
 * @Title: 胡椒披萨
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/21
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class PepperPizza extends Pizza {
    private String name;
    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void prepare() {
        System.out.println("准备...");
    }

    @Override
    public void bake() {
        System.out.println("烘烤...");
    }

    @Override
    public void cut() {
        System.out.println("切块...");
    }

    @Override
    public void box() {
        System.out.println("包装...");
    }
}
