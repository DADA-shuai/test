package com.atguigu.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.security.RunAs;

@SpringBootTest
class SpringBoot01HelloworldQuickApplicationTests {

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        Boolean helloService = ioc.containsBean("helloService");
        System.out.println(helloService);
    }

}
