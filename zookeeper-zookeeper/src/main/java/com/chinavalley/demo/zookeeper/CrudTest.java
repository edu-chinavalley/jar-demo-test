package com.chinavalley.demo.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;

/**
 * @author: polfdark
 */
public class CrudTest {

    public static void main(String ...args){
        CuratorFramework curator = CuratorFrameworkFactory.builder()
                .connectString("192.168.1.101:2181")
                .retryPolicy(new RetryOneTime(5000))
                .build();

        curator.start();
        create(curator);

    }

    public static void create(CuratorFramework curatorFramework){
        /**
         * creatingParentsIfNeeded
         * 如果父节点不存在会先创建父节点再创建子节点
         */
        try {
            String result = curatorFramework.create().creatingParentsIfNeeded()
                    /**
                     * CreateMode
                     *
                     */
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath("/curator","zwj".getBytes());
                    System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
