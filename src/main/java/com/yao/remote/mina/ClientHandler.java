package com.yao.remote.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by yao on 15/8/10.
 */
public class ClientHandler extends IoHandlerAdapter {

    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("client session :"+session.getId());

        session.write("Hello World");

    }

    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("client:"+message);
    }

}
