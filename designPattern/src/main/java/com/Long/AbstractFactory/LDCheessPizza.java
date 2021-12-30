package com.Long.AbstractFactory;

/**
 * @Title:  伦敦芝士披萨
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/24
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class LDCheessPizza extends Pizza {
    @Override
    public String getName() {
        return super.getName();
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

    @Override
    public void setName(String name) {

    }
}
