package com.gupao.vip.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author wangmeng
 * @date 2019/7/20
 * @desciption
 */
public class ConnectionDemo {

    public static void main(String[] args) {


        try {

            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper =
                    new ZooKeeper("192.168.1.7:2181,192.168.1.8:2181,192.168.1.9:2181", 4000, new Watcher() {
                        @Override
                        public void process(WatchedEvent watchedEvent) {
                            if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                                countDownLatch.countDown();
                            }
                        }
                    });

            countDownLatch.await();

            //NOT_CONNECTED   CONNECTING   CONNECTED  CLOSE
            System.out.println(zooKeeper.getState());// CONNECTING
           /* Thread.sleep(1000);
            System.out.println(zooKeeper.getState());*/// CONNECTED
            zooKeeper.create("/zk-persis-mic", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            Thread.sleep(1000);
            Stat stat = new Stat();
            //当前节点的值
            byte[] bytes = zooKeeper.getData("/zk-persis-mic", null, stat);
            System.out.println(new String(bytes));
            // 修改节点值
            zooKeeper.setData("/zk-persis-mic","1".getBytes(),stat.getVersion());

            byte[] bytes1 = zooKeeper.getData("/zk-persis-mic", null, stat);
            System.out.println(new String(bytes1));

            zooKeeper.delete("/zk-persis-mic", stat.getVersion());


            zooKeeper.close();

            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
