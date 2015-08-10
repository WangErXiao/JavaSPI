package com.yao.remote.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by yao on 15/8/10.
 */
public class ServerHandler  extends IoHandlerAdapter{

    public void sessionCreated(IoSession session) throws Exception {

        System.out.println("IoSession created :"+session.getId());
    }

    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("IoSession open:"+session.getId());
    }

    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("IoSession close:"+session.getId());
    }

    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("IoSession "+session.getId()+" receive msg:"+message.toString());

        session.write("i received " + message);
    }


}
