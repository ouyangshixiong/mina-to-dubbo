package com.example.handler;

import com.example.protocol.DemoMsgDto;
import com.example.protocol.ProtocolWrapper;
import com.example.service.DemoService;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class TextMsgHandler implements IMsgHandler{

    @Autowired
    DemoService demoService;

    @Value("${cmd.text}")
    private String CMD;

    public void process(IoSession session, Object o) {
        ProtocolWrapper protocolWrapper = new ProtocolWrapper();
        protocolWrapper.setCMD(CMD);
        protocolWrapper.setT(demoService.readMsgFromDb( (String)o ));
        session.write(protocolWrapper);
    }
}
