package com.lcl.serviceplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.lcl.serviceplatform.Dao")
@SpringBootApplication
public class ServiceplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceplatformApplication.class, args);
    }

}
