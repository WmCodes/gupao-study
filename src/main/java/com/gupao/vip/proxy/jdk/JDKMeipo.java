package com.gupao.vip.proxy.jdk;

import com.gupao.vip.proxy.staticProxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class JDKMeipo implements InvocationHandler {


    // 被代理的对象，把引用给保存下来
    private Person target;

    public Object getInstance(Person target) throws Exception{
        this.target = target;

        Class<?> clazz = target.getClass();

        // 用来生成一个新的对象（字节码重组）
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("寻找对象,已获得需求");
        method.invoke(this.target, args);
        System.out.println("寻找结束");

        return null;
    }
}
