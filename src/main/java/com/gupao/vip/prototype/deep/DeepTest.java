package com.gupao.vip.prototype.deep;

/**
 * @author wangmeng
 * @date 2019/7/14
 * @desciption
 */
public class DeepTest {

    public static void main(String[] args) {

        SunWuKong sunWuKong = new SunWuKong();

        try {
            SunWuKong clone = (SunWuKong)sunWuKong.clone();
            System.out.println(sunWuKong == clone);
            System.out.println(sunWuKong.jinGuBang == clone.jinGuBang);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
