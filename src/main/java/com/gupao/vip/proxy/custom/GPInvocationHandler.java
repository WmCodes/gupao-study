package com.gupao.vip.proxy.custom;

import java.lang.reflect.Method;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws  Throwable;
}
