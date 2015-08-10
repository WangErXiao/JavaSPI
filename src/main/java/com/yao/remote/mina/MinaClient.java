package com.yao.remote.mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

/**
 * Created by yao on 15/8/10.
 */
public class MinaClient {
    public static void main(String[]args){

        NioSocketConnector connector=new NioSocketConnector();

        DefaultIoFilterChainBuilder chain=connector.getFilterChain();

        chain.addLast("myChain", new ProtocolCodecFilter(new TextLineCodecFactory()));

        connector.setHandler(new ClientHandler());

        ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1", 9999));

        cf.awaitUninterruptibly();

        cf.getSession().getCloseFuture().awaitUninterruptibly();

        connector.dispose();

    }
}
