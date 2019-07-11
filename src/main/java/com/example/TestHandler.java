package com.example;

import com.example.protocol.AbstractMinaHandler;
import com.example.protocol.DemoMsgDto;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestHandler extends AbstractMinaHandler {

    private final Logger log = LoggerFactory.getLogger(TestHandler.class);

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        DemoMsgDto msgDto = (DemoMsgDto) message;
        log.info("server received message=" + msgDto.getDemoMsg());
        DemoMsgDto respMsgDto = new DemoMsgDto();
        respMsgDto.setDemoMsg("server say hello");
        session.write(respMsgDto);
    }
}
