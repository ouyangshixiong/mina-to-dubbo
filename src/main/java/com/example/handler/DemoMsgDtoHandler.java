package com.example.handler;

import com.example.protocol.DemoMsgDto;
import com.example.service.DemoService;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoMsgDtoHandler implements IMsgHandler{

    @Autowired
    DemoService demoService;

    public void process(IoSession session, Object message) {
        DemoMsgDto msgDto = (DemoMsgDto) message;
        DemoMsgDto respMsgDto = new DemoMsgDto();
        respMsgDto.setDemoMsg(demoService.readMsgFromDb(msgDto.getDemoMsg()));
        session.write(respMsgDto);
    }
}
