package com.gupao.vip.factory.simple;

import com.gupao.vip.factory.Mengniu;
import com.gupao.vip.factory.Milk;
import com.gupao.vip.factory.Telunsu;
import com.gupao.vip.factory.Yili;

/**
 * @author wangmeng
 * @date 2019/6/23
 * @desciption
 */
public class SimpleFactory {

    public Milk getMilk(String name){
        if ("特仑苏".equals(name)){
            return new Telunsu();
        }else if ("伊利".equals(name)){
            return new Yili();
        }else if ("蒙牛".equals(name)){
            return new Mengniu();
        }
        return null;
    }
}
