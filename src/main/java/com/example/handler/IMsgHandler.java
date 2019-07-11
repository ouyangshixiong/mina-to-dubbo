package com.example.handler;

import org.apache.mina.core.session.IoSession;

public interface IMsgHandler<T>
{
    void process(IoSession session, T t);
}
