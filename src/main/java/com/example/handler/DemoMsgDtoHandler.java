package com.example.handler;

import com.example.protocol.DemoMsgDto;
import com.example.protocol.ProtocolWrapper;
import com.example.service.DemoService;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class DemoMsgDtoHandler<T> implements IMsgHandler<T>{

    @Value("${cmd.msgdto}")
    private String CMD;

    @Autowired
    DemoService demoService;

    public void process(IoSession session, T t) {
        ProtocolWrapper req = (ProtocolWrapper)t;
        DemoMsgDto respMsgDto = new DemoMsgDto();
        ProtocolWrapper protocolWrapper = new ProtocolWrapper();
        protocolWrapper.setCMD(CMD);
        String reqContent = ((DemoMsgDto)req.getT()).getDemoMsg();
        respMsgDto.setDemoMsg(demoService.readMsgFromDb(reqContent));
        protocolWrapper.setT(respMsgDto);
        protocolWrapper.setSequenceNumber(req.getSequenceNumber());
        session.write(protocolWrapper);
    }
}
