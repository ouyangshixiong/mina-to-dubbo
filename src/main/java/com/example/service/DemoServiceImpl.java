package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{

    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);


    public String readMsgFromDb(String clientMsg){
        log.info("client Message=" + clientMsg);
        //just mock
        return "Read from fake DB";
    }
}
