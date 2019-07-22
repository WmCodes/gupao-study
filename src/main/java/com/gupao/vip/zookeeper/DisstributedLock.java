package com.gupao.vip.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author wangmeng
 * @date 2019/7/20
 * @desciption
 */
public class DisstributedLock implements Lock, Watcher {


    private ZooKeeper zk = null;
    private String ROOT_LOCK = "/locks"; // 定义根节点
    private String WAIT_LOCK; //等待前一个锁
    private String CURRENT_LOCK;// 表示当前的锁


    private CountDownLatch countDownLatch;

    public DisstributedLock() {
        try {
            zk = new ZooKeeper("192.168.1.7:2181",4000,this);
            // 判断根节点是否存在
            Stat stat = zk.exists(ROOT_LOCK, false);
            if (stat == null){
                // 创建一个持久化的节点
                zk.create(ROOT_LOCK, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lock() {
        if (this.tryLock()){
            System.out.println(Thread.currentThread().getName()+"->>>>>>>>>>>>>"+CURRENT_LOCK+"->获得锁成功");
            return;
        }

        waiteForLock(WAIT_LOCK);
    }

    private boolean waiteForLock(String prev){
        try {
            Stat stat = zk.exists(prev, true); // 监听上一个节点
            if (stat != null){
                System.out.println(Thread.currentThread().getName()+"------->等待锁"+ROOT_LOCK+"/"+prev+"释放");
                countDownLatch = new CountDownLatch(1);
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName()+"---->获得锁成功");
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        // 创建临时有序节点
        try {
            CURRENT_LOCK = zk.create(ROOT_LOCK+"/", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(Thread.currentThread().getName()+"------->"+CURRENT_LOCK+",尝试竞争锁");
            List<String> childrens = zk.getChildren(ROOT_LOCK, false);// 获取根节点下的所有子节点
            SortedSet<String> sortedSet = new TreeSet<String>();
            for (String children :childrens){
                sortedSet.add(ROOT_LOCK+"/"+ children);
            }
            String firstNode = sortedSet.first();//获取当前所有子节点中最小的节点
            // 返回从开始到指定元素的集合
            SortedSet<String> lessThenMe = (TreeSet<String>)sortedSet.headSet(CURRENT_LOCK);
            if (CURRENT_LOCK.equals(firstNode)){
                // 当前节点和最小节点进行对比
                return true;
            }
            if (!lessThenMe.isEmpty()){
                // 获得比当前节点更小的最后一个节点，设置给WAIT_LOCK
                WAIT_LOCK = lessThenMe.last();
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        System.out.println(Thread.currentThread().getName()+"--->释放锁"+CURRENT_LOCK);
        try {
            zk.delete(CURRENT_LOCK, -1);
            CURRENT_LOCK = null;
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        // 增删改会触发
        if (this.countDownLatch != null){
            this.countDownLatch.countDown();
        }
    }
}
