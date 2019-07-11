package com.gupao.vip.factory.func;

import com.gupao.vip.factory.Milk;
import com.gupao.vip.factory.Telunsu;

/**
 * @author wangmeng
 * @date 2019/6/23
 * @desciption
 */
public class TelunsuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
