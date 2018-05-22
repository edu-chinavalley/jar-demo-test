package com.chinavalley.demo.zookeeper;

//import org.apache.curator.connection.StandardConnectionHandlingPolicy;
import org.apache.curator.ensemble.fixed.FixedEnsembleProvider;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.framework.api.CreateBuilder;
import org.apache.curator.framework.imps.GzipCompressionProvider;
import org.apache.curator.framework.state.ConnectionState;
//import org.apache.curator.framework.state.StandardConnectionStateErrorPolicy;
import org.apache.curator.retry.*;
import org.apache.curator.utils.DefaultZookeeperFactory;
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.ZooDefs;
//import org.apache.zookeeper.data.ACL;
//import org.apache.zookeeper.data.Id;

import java.util.ArrayList;
import java.util.List;

public class ConnectTest {

    public static void main(String ...args){
        String zkAddress = "192.168.1.101:2181,192.168.1.102:2181";
        CuratorFramework curator = CuratorFrameworkFactory.builder()

                /**
                 * 连接服务器的地址
                 *
                 */
                .connectString(zkAddress)

                /**
                 * session 超时时间 单位 ms
                 * 默认:60 * 1000 ms
                 */
                .sessionTimeoutMs(60000)

                /**
                 * 连接超时时间 单位 ms
                 * 默认:60 * 1000 ms
                 */
                .connectionTimeoutMs(60000)

                /**
                 * 命名空间
                 * 该client所有的操作都在命名空间之后
                 */
                .namespace("")

                /**
                 * 确认客户端的重联策略
                 *  1、{@link BoundedExponentialBackoffRetry}
                 *  2、{@link ExponentialBackoffRetry} 重试指定的次数,且每一次重试之间停顿的时间逐渐增加 动态CD时间
                 *  3、{@link RetryForever} 无限重试
                 *  4、{@link RetryNTimes} 指定重连的次数
                 *  5、{@link RetryOneTime} 只重连一次,设置间隔
                 *  6、{@link RetryUntilElapsed} 指定最大重连超时时间和重连时间间隔,间歇性重连直到超时或者链接成功
                 *  7、{@link SleepingRetry}
                 */
                .retryPolicy(new RetryOneTime(1000))

                /**
                 * 动态提供配置
                 * 固定
                 * 1、{@link FixedEnsembleProvider} 使用固定字符串进行配置
                 * 配置器
                 * 1、{@link org.apache.curator.ensemble.exhibitor.ExhibitorEnsembleProvider} 动态的获取connectionString
                 */
                .ensembleProvider(new FixedEnsembleProvider(""))

                /**
                 *只能用于查询
                 */
                .canBeReadOnly(true)

                /**
                 * 数据序列化
                 * 1、GzipCompressionProvider gzip压缩
                 */
                .compressionProvider(new GzipCompressionProvider())

                /**
                 * 设置要使用的错误策略 默认是{@link StandardConnectionStateErrorPolicy}
                 * 默认状态为ConnectionState类 状态自己看{@link ConnectionState}
                 */
                //.connectionStateErrorPolicy(new StandardConnectionStateErrorPolicy())

                /**
                 * 更改连接处理策略
                 * 默认策略:{@link StandardConnectionHandlingPolicy}
                 *
                 */
                //.connectionHandlingPolicy(new StandardConnectionHandlingPolicy())

                /**
                 * 默认path管理
                 * 在默认情况下,是使用{@link CreateBuilder#creatingParentContainersIfNeeded()}函数
                 * 如果zk jar支持{@link CreateMode#CONTAINER}的话,则关闭此行为。
                 * 
                 */
                // TODO: 2018/5/21 作用不详
                .dontUseContainerParents()

                /**
                 * 默认创建的根节点是没有做权限控制的,需要自己手动加权限
                 */
//                .aclProvider(new ACLProvider() {
//                    private List<ACL> acl;
//                    @Override
//                    public List<ACL> getDefaultAcl() {
//                        if(acl ==null){
//                            ArrayList<ACL> acl = ZooDefs.Ids.CREATOR_ALL_ACL;
//                            acl.clear();
//                            acl.add(new ACL(ZooDefs.Perms.ALL, new Id("auth", "admin:admin") ));
//                            this.acl = acl;
//                        }
//                        return acl;
//                    }
//
//                    @Override
//                    public List<ACL> getAclForPath(String path) {
//                        return acl;
//                    }
//                })

                /**
                 * 添加链接授权，反复调用将覆盖
                 */
                .authorization("scheme","admin:admin".getBytes())

                /**
                 * 在使用{@link PathAndBytesable#forPath(String)}的函数的时候使用
                 * 在调试时使用，可以设置成客户端ip
                 */
                .defaultData("asd".getBytes())

                /**
                 * 添加强制模式集
                 * 默认:空
                 * 
                 */
                // TODO: 2018/5/21 作用不详
                //.schemaSet()

                /**
                 * 如果是true 创建一个3.4.X的兼容客户端
                 *
                 * 如果使用zookeeper3.4.X的客户端，则默认启用
                 * 4.0curator专有
                 */
                // TODO: 2018/5/21 作用不详
                //.zk34CompatibilityMode(false)

                /**
                 * 默认使用zookeeper的工厂类
                 * 默认:{@link DefaultZookeeperFactory}
                 */
                // TODO: 2018/5/21 作用不详
                .zookeeperFactory(new DefaultZookeeperFactory())

                /**
                 * 线程工厂类
                 * 默认:null
                 */
                // TODO: 2018/5/21 作用不详
                .threadFactory(null)
                /**
                 * 构建
                 */
                .build();

    }
}
