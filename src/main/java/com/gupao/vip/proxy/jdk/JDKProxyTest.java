package com.gupao.vip.proxy.jdk;

import com.gupao.vip.proxy.staticProxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author wangmeng
 * @date 2019/7/15
 * @desciption
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        try {
            Person obj = (Person) new JDKMeipo().getInstance(new Xiemu());
            System.out.println(obj.getClass());
            obj.findLove();

            // 原理
            // 1.拿到被代理对象的引用，并且获得它的所有接口，反射获取
            // 2. JDK Proxy类重新生成一个新的类，同时新的类要实现被代理类所有的实现接口
            // 3. 动态生成java代码，把新加的业务业务逻辑方法由一定的逻辑代码去调用(在代码中去体现)
            // 4. 编译新生成的java代码.class
            // 5. 在重新加载到JVM中运行
            // 以上为字节码重组


            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
