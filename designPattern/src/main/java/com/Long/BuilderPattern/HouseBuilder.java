package com.Long.BuilderPattern;

/**
 * @Title: 抽象建造者 产品和builder是一个组合关系
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/27
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public abstract class HouseBuilder {
    protected House house = new House();

    /**
     * 建造的抽象方法
     */
    abstract void buildBisic();

    abstract void buildWalls();

    abstract void roofed();

    abstract House build();

    //返回产品房子
    public House buildHouse() {
        System.out.println("房子建造成功！");
        return house;
    }


}
