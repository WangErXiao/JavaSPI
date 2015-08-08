package com.yao.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by yao on 15/8/8.
 */
public class MultiCastSend {

    public static void main(String[]args){
        try {
            //指定组播IP
            InetAddress ip = InetAddress.getByName("228.5.6.7");

            MulticastSocket s = new MulticastSocket();
            //加入该组
            s.joinGroup(ip);

            //在多播中设置了TTl值（Time to live），每一个ip数据报文中都包含一个TTL，
            //每当有路由器转发该报文时，TTL减1，知道减为0时，生命周期结束，报文即时没有到达目的地，
            //也立即宣布死亡。当然在Java中，ttl并不是十分准确的，
            //曾经在一本书中介绍过报文的传播距离是不会超过ttl所设置的值的。
            s.setTimeToLive(1);

            String msg = "hello world";
            DatagramPacket hi = new DatagramPacket(msg.getBytes(), msg.length(),ip, 6789);
            s.send(hi);
            s.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
