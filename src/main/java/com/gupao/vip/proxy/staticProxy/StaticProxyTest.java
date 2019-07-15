package com.gupao.vip.proxy.staticProxy;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class StaticProxyTest {

    public static void main(String[] args) {

        // 只能代理儿子
        Father father = new Father(new Son());
        father.FindLove();
    }
}
