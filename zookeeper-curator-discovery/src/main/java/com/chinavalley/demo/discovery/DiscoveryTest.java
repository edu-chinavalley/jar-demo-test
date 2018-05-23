package com.chinavalley.demo.discovery;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.*;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import java.util.Collection;

/**
 * @author: polfdark
 */
public class DiscoveryTest {

    public static void main(String ...args) throws Exception {

        CuratorFramework curator = CuratorFrameworkFactory.builder()
                .connectString("192.168.1.101:2181")
                .retryPolicy(new RetryOneTime(3000))
                .build();

        curator.start();
        JsonInstanceSerializer<ServiceDetail> json = new JsonInstanceSerializer<>(ServiceDetail.class);


        ServiceInstance<ServiceDetail> instance = ServiceInstance.<ServiceDetail>builder()
                .address("192.168.1.1")
                .id("host1")
                .name("com")
                .port(8080)
                .serviceType(ServiceType.STATIC)
                .build();
        ServiceDiscovery<ServiceDetail> serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceDetail.class)
                .basePath("/asd")
                .client(curator)
                .serializer(json)
                .thisInstance(instance)
                .watchInstances(true)
                .build();
        //serviceDiscovery.registerService(instance);
        serviceDiscovery.start();
        ServiceInstance<ServiceDetail> instance2 = ServiceInstance.<ServiceDetail>builder()
                .address("192.168.1.1")
                .id("host2")
                .name("com")
                .port(8080)
                .serviceType(ServiceType.STATIC)
                .build();

        serviceDiscovery.registerService(instance2);


        Collection<ServiceInstance<ServiceDetail>> list = serviceDiscovery.queryForInstances("com");

    }
}
