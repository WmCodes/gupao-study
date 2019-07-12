package com.gupao.vip.singleton.seriable;

import java.io.Serializable;

/**
 * @author wangmeng
 * @date 2019/7/12
 * @desciption
 */
public class Seriable implements Serializable {

    public final static Seriable INSTANCE = new Seriable();
    private Seriable(){}

    public static Seriable getInstance(){
        return INSTANCE;
    }


    // 解决序列化 及反序列化后 对象不是同一个对象
    private Object readResolve(){
        return INSTANCE;
    }
}
