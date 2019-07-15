package com.gupao.vip.proxy.custom;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class GPProxy {

    public static Object newProxyInstance(GPClassLoader classLoader,Class<?> interfaces,GPInvocationHandler h){
        // 1.动态生成源代码.java文件
            generateSrc(interfaces);
        // 2.java文件输出磁盘


        // 3.把生成的java文件编译成.class文件

        // 4.编译生成的.class文件加载到jvm当中


        // 5.返回字节码重组以后的新的代理对象



        return null;
    }

    private static String generateSrc(Class<?> interfaces){
            StringBuffer sb = new StringBuffer();
            return null;
    }
}
