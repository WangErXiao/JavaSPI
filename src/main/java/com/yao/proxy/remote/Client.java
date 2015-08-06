package com.yao.proxy.remote;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by yao on 15/8/6.
 */
public class Client {

    private int port=9999;
    private String host="127.0.0.1";

    public Client(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public Client() {
    }

    public Object invoke(RpcInfo info) throws IOException, ClassNotFoundException {
        Socket socket=new Socket();
        socket.connect(new InetSocketAddress(host,port));
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(info);
        return new ObjectInputStream(socket.getInputStream()).readObject();
    }

}
