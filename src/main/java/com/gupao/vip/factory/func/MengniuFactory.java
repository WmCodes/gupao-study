package com.gupao.vip.factory.func;

import com.gupao.vip.factory.Mengniu;
import com.gupao.vip.factory.Milk;

/**
 * @author wangmeng
 * @date 2019/6/23
 * @desciption
 */
public class MengniuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
