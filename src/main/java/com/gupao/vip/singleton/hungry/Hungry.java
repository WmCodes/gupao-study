package com.gupao.vip.singleton.hungry;

/**
 * @author wangmeng
 * @date 2019/7/12
 * @desciption
 */
public class Hungry {

    /**
     *
     *
     * @author wangmeng
     * @date 2019/7/12 10:31
     * @param []
     * @return
     * @Instructions   饿汉式
     */

    // 构造方法私有化
    private Hungry(){};

    // 加载顺序: 先静态 后动态，先属性 后方法  先上后下
    private static final Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
       // System.out.println(System.currentTimeMillis()+":"+HUNGRY);
        return HUNGRY;
    }

}
