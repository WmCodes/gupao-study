package com.gupao.vip.factory.abstr;

/**
 * @author wangmeng
 * @date 2019/6/23
 * @desciption
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {

        MilkFactory factory = new MilkFactory();

        //用户只有选择的圈存，保证程序的简装性
        System.out.println(factory.getMengniu());

    }
}
