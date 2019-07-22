package com.gupao.vip.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

/**
 * @author wangmeng
 * @date 2019/7/20
 * @desciption
 */
public class CuratorDemo {

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().build();
        InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework,"/locks");
        try {
            interProcessMutex.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
