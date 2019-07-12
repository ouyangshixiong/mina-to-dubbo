package com.example.handler;

import com.example.protocol.DemoMsgDto;
import com.example.protocol.ProtocolWrapper;
import com.example.service.DemoService;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class DemoMsgDtoHandler implements IMsgHandler{

    @Value("${cmd.msgdto}")
    private String CMD;

    @Autowired
    DemoService demoService;

    public void process(IoSession session, Object message) {
        DemoMsgDto msgDto = (DemoMsgDto) message;
        DemoMsgDto respMsgDto = new DemoMsgDto();
        ProtocolWrapper protocolWrapper = new ProtocolWrapper();
        protocolWrapper.setCMD(CMD);
        respMsgDto.setDemoMsg(demoService.readMsgFromDb(msgDto.getDemoMsg()));
        protocolWrapper.setT(respMsgDto);
        session.write(protocolWrapper);
    }
}
