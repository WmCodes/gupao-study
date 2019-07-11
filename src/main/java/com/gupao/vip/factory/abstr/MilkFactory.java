package com.gupao.vip.factory.abstr;

import com.gupao.vip.factory.Milk;
import com.gupao.vip.factory.Sanlu;
import com.gupao.vip.factory.func.MengniuFactory;
import com.gupao.vip.factory.func.TelunsuFactory;
import com.gupao.vip.factory.func.YiliFactory;

/**
 * @author wangmeng
 * @date 2019/6/23
 * @desciption
 */
public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getMengniu() {
        return new MengniuFactory().getMilk();
    }

    @Override
    public Milk getYili() {
        return new YiliFactory().getMilk();
    }

    @Override
    public Milk getTelunsu() {
        return new TelunsuFactory().getMilk();
    }

    @Override
    public Milk getSanlu() {
        return new Sanlu();
    }
}
