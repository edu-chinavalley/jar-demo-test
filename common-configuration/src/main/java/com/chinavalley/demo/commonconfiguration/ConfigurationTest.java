package com.chinavalley.demo.commonconfiguration;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ConfigurationTest {

    public static void main(String ...args) throws ConfigurationException {
        Configurations configurations = new Configurations();
        PropertiesConfiguration p = configurations.properties("config.property");
        System.out.println(p.getString("name"));
    }
}
