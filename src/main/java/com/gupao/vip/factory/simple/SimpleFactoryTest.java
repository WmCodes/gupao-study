package com.gupao.vip.factory.simple;

/**
 * @author wangmeng
 * @date 2019/6/23
 * @desciption
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {


        //System.out.println(new Telunsu().geyName());

        SimpleFactory factory = new SimpleFactory();
        System.out.println(factory.getMilk("蒙牛").geyName());



    }
}
