package com.gupao.vip.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author wangmeng
 * @date 2019/7/20
 * @desciption
 */
public class Zookeeper {

    public static void main(String[] args) throws IOException {

        final CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0;i<10;i++){

            new Thread(()->{
                try {
                    countDownLatch.await();
                    DisstributedLock disstributedLock = new DisstributedLock();
                    disstributedLock.lock();//获得所
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"Thread---"+i).start();

            countDownLatch.countDown();

        }


            System.in.read();



    }
}
