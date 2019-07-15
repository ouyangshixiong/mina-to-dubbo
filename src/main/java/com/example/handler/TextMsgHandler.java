package com.example.handler;

import com.example.protocol.DemoMsgDto;
import com.example.protocol.ProtocolWrapper;
import com.example.service.DemoService;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class TextMsgHandler<T> implements IMsgHandler<T>{

    private static final Logger log = LoggerFactory.getLogger(TextMsgHandler.class);

    @Autowired
    DemoService demoService;

    @Value("${cmd.text}")
    private String CMD;

    public void process(IoSession session, T t) {
        ProtocolWrapper req = (ProtocolWrapper)t;
        log.info("client message=" + (String) req.getT() + " sequence=" + req.getSequenceNumber());
        ProtocolWrapper protocolWrapper = new ProtocolWrapper();
        protocolWrapper.setCMD(CMD);
        protocolWrapper.setT( req.getT() );
        protocolWrapper.setSequenceNumber(req.getSequenceNumber());
        session.write(protocolWrapper);
    }
}
