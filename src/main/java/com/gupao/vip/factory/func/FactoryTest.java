package com.gupao.vip.factory.func;

/**
 * @author wangmeng
 * @date 2019/6/23
 * @desciption
 */
public class FactoryTest {

    public static void main(String[] args) {

    Factory factory = new MengniuFactory();
    System.out.println(factory.getMilk());

    }
}
