package com.gupao.vip.proxy.cglib;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class CgLibTest {

    public static void main(String[] args) {
        ZhangSan obj = null;

        try {
            obj = (ZhangSan)new CgLibMeiPo().getInstance(ZhangSan.class);
            obj.findLove();
            System.out.println(obj.getClass());

            //
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
