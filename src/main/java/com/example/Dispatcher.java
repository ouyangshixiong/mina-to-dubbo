package com.example;

import com.example.handler.IMsgHandler;
import com.example.protocol.ProtocolWrapper;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Dispatcher<T> extends IoHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(Dispatcher.class);

    private IoHandler ioHandler;

    private Map<String, IMsgHandler<T>> handlerMapping;

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        if (session.isClosing() || !session.isConnected())
        {
            log.error("Client closed or lost connection!");
            return;
        }
        ProtocolWrapper protocolWrapper = (ProtocolWrapper)message;
        String CMD = protocolWrapper.getCMD();
        IMsgHandler<T> businessHandler = dispatch(CMD);
        T t = (T) protocolWrapper.getT();
        businessHandler.process(session,t);
//        if( ioHandler != null ){
//            IMsgHandler<T> businessHandler = dispatch(CMD);
//            T t = (T) protocolWrapper.getT();
//            businessHandler.process(session,t);
//        }else{
//            log.error("ioHandler is null!");
//        }


    }


    //按appContext.xml里面配置的handlerMapping配置的字符串和对应类分发
    public IMsgHandler<T> dispatch(String handlerKey)
    {
        IMsgHandler<T> t = handlerMapping.get(handlerKey);
        if (t != null){
            return t;
        }
        log.error("there are no business handler in configuration file!");
        return null;
    }

    public IoHandler getIoHandler() {
        return ioHandler;
    }

    public void setIoHandler(IoHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    public Map<String, IMsgHandler<T>> getHandlerMapping() {
        return handlerMapping;
    }

    public void setHandlerMapping(Map<String, IMsgHandler<T>> handlerMapping) {
        this.handlerMapping = handlerMapping;
    }
}
