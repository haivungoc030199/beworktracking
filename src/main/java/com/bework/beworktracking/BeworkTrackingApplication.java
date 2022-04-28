package com.bework.beworktracking;

import com.bework.beworktracking.common.constants.Consts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BeworkTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeworkTrackingApplication.class, args);

        Consts.init();
    }

}
