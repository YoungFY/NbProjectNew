package com.Long.singlePattern;

/**
 * @Title: 通过静态内部类的模式可以实现
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2022/1/10
 * @Copyright: Copyright(c)2022 RedaFlight.com All Rights Reserved
 */
public class StaticSinglePattern {

    private StaticSinglePattern() {

    }

    private static class SingleDemo {
        private static SingleDemo instance = new SingleDemo();
    }

    public static SingleDemo getInstance() {
        return SingleDemo.instance;
    }


}
