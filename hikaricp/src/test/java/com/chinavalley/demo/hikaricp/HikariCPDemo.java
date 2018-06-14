package com.chinavalley.demo.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HikariCPDemo {
    private HikariDataSource dataSource;

    public HikariCPDemo() {
    }

    public void init() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("");
        config.setUsername("");
        config.setPassword("");
        config.setDataSourceClassName("");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
        config.addDataSourceProperty("useLocalSessionState", "true");
        config.addDataSourceProperty("useLocalTransactionState", "true");
        config.addDataSourceProperty("rewriteBatchedStatements", "true");
        config.addDataSourceProperty("cacheResultSetMetadata", "true");
        config.addDataSourceProperty("cacheServerConfiguration", "true");
        config.addDataSourceProperty("elideSetAutoCommits", "true");
        config.addDataSourceProperty("maintainTimeStats", "false");
        config.setAutoCommit(true);
        config.setReadOnly(false);
        config.setConnectionTimeout(30000L);
        config.setIdleTimeout(600000L);
        config.setMaxLifetime(1800000L);
        config.setMaximumPoolSize(10);
        config.setValidationTimeout(5000L);
        config.setTransactionIsolation(null);
        config.setLeakDetectionThreshold(0L);
        config.setCatalog(null);
        config.setConnectionTestQuery(null);
        config.setPoolName(null);
        config.setConnectionInitSql(null);
        this.setDataSource(new HikariDataSource(config));
    }

    public HikariDataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        Connection con = null;

        try {
            con = this.getDataSource().getConnection();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return con;
    }

    public static void main(String[] args) throws Exception {
        HikariCPDemo demo = new HikariCPDemo();
        demo.init();
        System.out.println(demo.getConnection().getCatalog());
        PreparedStatement statement = demo.getConnection().prepareStatement("select id from ips_merch_key");
        ResultSet set = statement.executeQuery();

        while(set.next()) {
            System.out.println(set.getInt("id"));
        }

    }
}
