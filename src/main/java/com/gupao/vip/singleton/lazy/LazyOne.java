package com.gupao.vip.singleton.lazy;

/**
 * @author wangmeng
 * @date 2019/7/12
 * @desciption
 */
public class LazyOne {


    // 饿汉式  ，并发也有可能不产生单例
    private LazyOne(){}

    private static LazyOne lazy = null;

    public static LazyOne getInstance(){

        if (lazy == null){
            lazy = new LazyOne();
        }
        return lazy;
    }
}
