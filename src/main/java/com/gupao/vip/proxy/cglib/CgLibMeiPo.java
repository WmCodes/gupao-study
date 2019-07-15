package com.gupao.vip.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption cglib动态代理
 */
public class CgLibMeiPo implements MethodInterceptor
{

    public Object getInstance(Class<?> clazz) throws Exception{

        Enhancer enhancer = new Enhancer();
        // 要把那个类设置为即将生成的新类父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理准备");
        // 业务的增强
        methodProxy.invokeSuper(o,objects);
        System.out.println("代理结束");
        return null;
    }
}
