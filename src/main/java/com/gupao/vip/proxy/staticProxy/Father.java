package com.gupao.vip.proxy.staticProxy;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class Father {

    private Person person;

    public Father(Person person){
        this.person = person;
    }

    // 目标对象的引用
    public void FindLove(){

        System.out.println("要求111111111111111111111111");
        this.person.findLove();
        System.out.println("要求22222222222222222");
    }
}
