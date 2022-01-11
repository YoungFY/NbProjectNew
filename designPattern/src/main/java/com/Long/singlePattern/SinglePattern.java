package com.Long.singlePattern;

/**
 * @Title: 在多线程环境下的单例模式
 * @Description:
 * @Author: guowl
 * @version： 1.0
 * @Date:2022/1/10
 * @Copyright:
 */
public class SinglePattern {
    //通过添加 volatile 可以禁止指令重拍，实现线程安全延迟初始化
    private volatile static SinglePattern singlePattern;

    private SinglePattern() {

    }
    //双重锁设计模式
    public static SinglePattern getInstance() {
        if (singlePattern == null) {

            synchronized (SinglePattern.class) {
                if (singlePattern == null) {
                    //隐患 在多线程环境下，由于重新排序，该对象可能还未完成初始化就被其他线程读取
                    //通过volatile 禁止 初始化对象（禁止指令重新排序） 设置singleton
                    singlePattern = new SinglePattern();
                }
            }
        }
        return singlePattern;
    }

}
