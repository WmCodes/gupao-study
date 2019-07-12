package com.gupao.vip.singleton.lazy;

/**
 * @author wangmeng
 * @date 2019/7/12
 * @desciption
 */
public class LazyThree {

    private static boolean initialized = false;
    //  默认使用LazyThree的时候，会先初始化内部类
    // 如果没使用的话，内部类是不加载

    private LazyThree(){


        synchronized (LazyThree.class){
            if (initialized == false){
                // 第一次初始化
                initialized = !initialized;
            }else {
                throw new RuntimeException("单例已被侵犯");
            }
        }

    }


    public static final LazyThree getInstance(){
        return LazyHolder.LAZY_THREE;
    }

    private static class LazyHolder{
        private static final LazyThree LAZY_THREE = new LazyThree();
    }
}
