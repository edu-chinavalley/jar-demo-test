package com.chinavalley.demo.metrics;


import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Test {

    public static Queue<String> q = new LinkedList<String>();


    public static void main(String[] args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(10, TimeUnit.SECONDS);
        registry.register(MetricRegistry.name(Test.class, "queue", "size"),
                new Gauge<Integer>() {
                    public Integer getValue() {
                        return q.size();
                    }
                });
        while(true){
            Thread.sleep(1000);
            q.add("Job-xxx");
        }
    }
}
