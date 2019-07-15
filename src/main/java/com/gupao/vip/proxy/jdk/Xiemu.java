package com.gupao.vip.proxy.jdk;

import com.gupao.vip.proxy.staticProxy.Person;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class Xiemu implements Person {

    @Override
    public void findLove(){
        System.out.println("有钱");
    }
}
