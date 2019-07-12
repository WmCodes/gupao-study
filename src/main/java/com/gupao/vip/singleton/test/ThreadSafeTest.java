package com.gupao.vip.singleton.test;

import com.gupao.vip.singleton.lazy.LazyThree;

import java.lang.reflect.Constructor;

/**
 * @author wangmeng
 * @date 2019/7/12
 * @desciption
 */
public class ThreadSafeTest {

    public static void main(String[] args) {

        try {
           Class<?> clazz = LazyThree.class;
           // 返回public 和 private
          Constructor[] cs = clazz.getDeclaredConstructors();
           for (Constructor c : cs ){
               // 用反射强制访问
               c.setAccessible(true);
               Object o = c.newInstance();
           }
            // 返回public
        /*    clazz.getConstructors();
            clazz.newInstance();*/
        }catch (Exception e){
            e.printStackTrace();
        }



      /*  int count = 100;
        // 计时器
        // 日常开发中经常会遇到需要在主线程中开启多线程去并行执行任务，
        // 并且主线程需要等待所有子线程执行完毕后再进行汇总的场景，它的内部提供了一个计数器，
        // 在构造闭锁时必须指定计数器的初始值，且计数器的初始值必须大于0。另外它还提供了一个countDown方法来操作计数器的值，
        // 每调用一次countDown方法计数器都会减1，直到计数器的值减为0时就代表条件已成熟，所有因调用await方法而阻塞的线程都会被唤醒。
        //
        final CountDownLatch latch = new CountDownLatch(count);

       // final Set<Hungry> syncSet = Collections.synchronizedSet(new HashSet<Hungry>());

        for (int i = 0;i<count;i++){
           new Thread(){
               @Override
               public void run() {
                  // syncSet.add(Hungry.getInstance());
                   //Object o  = Hungry.getInstance();
                   //  Object o  = LazyOne.getInstance();
                   try {
                       // latch.await()方法要求主线程等待所有10个检查任务全部准备好才一起并行执行。
                       latch.await();
                       Object o  = LazyThree.getInstance();
                       System.out.println(System.currentTimeMillis()+":"+o);
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
           }.start();
            // latch.countDown();方法作用是通知CountDownLatch有一个线程已经准备完毕，倒计数器可以减一了
           //System.out.println(latch.getCount());
           latch.countDown();
        }*/

    }

}
