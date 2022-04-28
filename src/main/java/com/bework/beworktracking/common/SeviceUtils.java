package com.bework.beworktracking.common;

import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.util.HashMap;
import java.util.Map;

public class SeviceUtils {
    public static Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        return props;
    }
}
