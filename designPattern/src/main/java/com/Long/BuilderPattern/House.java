package com.Long.BuilderPattern;

/**
 * @Title: 产品 product
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2021/12/27
 * @Copyright: Copyright(c)2021 RedaFlight.com All Rights Reserved
 */
public  class House {
    private String baise;
    private String wall;
    private String roofed;

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
