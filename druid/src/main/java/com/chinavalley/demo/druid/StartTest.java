package com.chinavalley.demo.druid;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author: polfdark
 */
public class StartTest {

    public static void main(String ...args) throws SQLException {
        DruidDataSource ds = new DruidDataSource();
        /**
         * 多数据源
         */
        ds.setName("test1");
        /**
         * 数据库地址
         */
        ds.setUrl("jdbc:mysql://asd:3306/zgpay");
        /**
         * 用户名
         */
        ds.setUsername("asd");
        /**
         * 密码
         */
        ds.setPassword("asd");

        /**
         * 数据库类型
         */
        //ds.setDriverClassName("");
        /**
         * 初始化时建立物理连接的个数 默认值为0
         */
        ds.setInitialSize(0);

        /**
         * 最大连接池数量 默认值为8
         */
        ds.setMaxActive(8);
        /**
         * 最小连接数
         */
        ds.setMinIdle(8);
        /**
         * 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，
         * 如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
         */
        ds.setMaxWait(5000L);
        /**
         *是否缓存preparedStatement，也就是PSCache。
         * PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
         */
        ds.setPoolPreparedStatements(false);
        /**
         * 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
         * 在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100
         */
        ds.setMaxPoolPreparedStatementPerConnectionSize(-1);
        /**
         * 用来检测连接是否有效的sql，要求是一个查询语句。
         * 如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。
         */
        ds.setValidationQuery("select 1");

        /**
         * 申请连接时执行validationQuery检测连接是否有效，
         * 做了这个配置会降低性能。
         */
        ds.setTestOnBorrow(true);
        /**
         * 归还连接时执行validationQuery检测连接是否有效，
         * 做了这个配置会降低性能
         */
        ds.setTestOnReturn(false);
        /**
         * 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，
         * 如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
         */
        ds.setTestWhileIdle(true);

        /**
         * 1) Destroy线程会检测连接的间隔时间
         * 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明
         */
        ds.setTimeBetweenEvictionRunsMillis(1000L);
        /**
         *
         */
        ds.setMinEvictableIdleTimeMillis(1000L);
        /**
         * 	物理连接初始化的时候执行的sql
         */
        ds.setConnectionInitSqls(new ArrayList<String>());

        /**
         *
         */
        ds.setExceptionSorter("");
        /**
         *
         */
        ds.setFilters("");
        /**
         *
         */
        ds.setProxyFilters(new ArrayList<Filter>());

        DruidPooledConnection pdc = ds.getConnection();
    }
}
