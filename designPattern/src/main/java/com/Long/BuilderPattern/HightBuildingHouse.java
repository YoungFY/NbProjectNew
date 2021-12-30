package com.Long.BuilderPattern;

/**
 * @Title:
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/27
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public class HightBuildingHouse extends HouseBuilder {

    @Override
    void buildBisic() {
        System.out.println("打桩.....");
    }

    @Override
    void buildWalls() {
        System.out.println("砌墙.....");
    }

    @Override
    void roofed() {
        System.out.println("修屋顶.....");
    }

    @Override
    House build() {
        System.out.println("房子建造成功！.....");
        return house;
    }

    @Override
    public House buildHouse() {
        House house = super.buildHouse();
        house.setBaise("10米地基");
        house.setRoofed("10普通屋顶");
        house.setWall("10米砖墙");
        return house;
    }
}
