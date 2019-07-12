package com.gupao.vip.singleton.lazy;

/**
 * @author wangmeng
 * @date 2019/7/12
 * @desciption
 */
public class LazyTwo {


    // 饿汉式  ，并发也有可能不产生单例,加synchronized后不会出现这种问题，消耗性能
    private LazyTwo(){}

    private static LazyTwo lazy = null;

    public static synchronized LazyTwo getInstance(){

        if (lazy == null){
            lazy = new LazyTwo();
        }
        return lazy;
    }
}
