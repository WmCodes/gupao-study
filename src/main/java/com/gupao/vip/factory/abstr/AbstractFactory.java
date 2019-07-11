package com.gupao.vip.factory.abstr;

import com.gupao.vip.factory.Milk;

/**
 * @author wangmeng
 * @date 2019/6/23
 * @desciption
 */
public  abstract class AbstractFactory {



    public abstract Milk getMengniu();
    public abstract  Milk getYili();
    public abstract  Milk getTelunsu();

    public abstract Milk getSanlu();

}
