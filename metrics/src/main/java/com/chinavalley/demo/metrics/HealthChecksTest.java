package com.chinavalley.demo.metrics;

import com.codahale.metrics.health.HealthCheck;

public class HealthChecksTest extends HealthCheck {
    
    @Override
    protected Result check() throws Exception {
        return null;
    }
}
