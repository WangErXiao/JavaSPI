package com.yao.proxy.remote;

import com.yao.proxy.HelloWorldImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yao on 15/8/6.
 */
public class Server {
    private int port=9999;

    private final static Map<String,Object> objCaches=new ConcurrentHashMap();
    static {
        objCaches.put("com.yao.proxy.HelloWorld",new HelloWorldImpl());
    }

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ServerSocket serverSocket=new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        for (;;) {
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());
            RpcInfo rpcInfo=(RpcInfo)objectInputStream.readObject();
            if(rpcInfo!=null&&rpcInfo.getClassName()!=null&&rpcInfo.getMethodName()!=null){
                Method method= objCaches.get(rpcInfo.getClassName()).getClass().getMethod(rpcInfo.getMethodName(), String.class);
                Object rel=method.invoke(objCaches.get(rpcInfo.getClassName()),rpcInfo.getArgs());
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(rel);
            }
        }
    }
    public static void main(String[]args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, IOException, NoSuchMethodException {
        Server server=new Server(9999);
        server.start();
    }
}
