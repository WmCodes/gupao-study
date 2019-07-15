package com.gupao.vip.prototype.simple;

import java.util.ArrayList;

/**
 * @author wangmeng
 * @date 2019/7/14
 * @desciption
 */
public class CloneTest {

    public static void main(String[] args) {
        Prototype p = new Prototype();

        p.setName("Tom");
        ArrayList<CloneTarget> arrayList = new ArrayList();
        arrayList.add(new CloneTarget());
        p.setList(arrayList);
        System.out.println(p.getList());
        try {
            Prototype obj = (Prototype)p.clone();
            System.out.println(obj.getList());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
       ;
    }
}
