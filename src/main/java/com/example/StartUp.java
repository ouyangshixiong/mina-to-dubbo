package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartUp {

    private static final Logger log = LoggerFactory.getLogger(StartUp.class);

    public static void main(String[] args) throws Exception
    {
        log.info("*************** Demo Server is starting ...***************");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        //带mina自建ExecutorFilter的配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContextWithExecutorFilter.xml");
        log.info("*************** Demo Server start up successfully!***************");
    }
}
