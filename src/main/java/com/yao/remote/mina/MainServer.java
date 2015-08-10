package com.yao.remote.mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChain;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by yao on 15/8/10.
 */
public class MainServer {

    public static void main(String[]args) throws IOException {

        SocketAcceptor acceptor= new NioSocketAcceptor();

        SocketSessionConfig sessionConfig=acceptor.getSessionConfig();

        sessionConfig.setReadBufferSize(1024);

        DefaultIoFilterChainBuilder chain=acceptor.getFilterChain();

        chain.addLast("myChain",new ProtocolCodecFilter(new TextLineCodecFactory()));

        acceptor.setHandler(new ServerHandler());

        acceptor.bind(new InetSocketAddress(9999));

        System.out.println("Server start........");

    }

}
