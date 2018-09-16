/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author quang
 */
public class server {
    public static void sendData(String data, DatagramSocket svSocket, InetAddress IPAddress, int port) throws IOException{
        byte[] sendData = new byte[1024];
        sendData = data.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        svSocket.send(sendPacket);
    }
    
    public static String receiveData(DatagramSocket svSocket) throws IOException{
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        svSocket.receive(receivePacket);
        String sentence = new String(receivePacket.getData());
        return sentence.trim();
    }
    
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here
        DatagramSocket svSocket = new DatagramSocket(1234);
        byte[] receive = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
        svSocket.receive(receivePacket);
        String sentence = new String(receivePacket.getData());
        System.out.println(sentence);
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        int num1, num2;
        sendData("Nhập số thứ nhất: ", svSocket, IPAddress, port);
        num1 = Integer.parseInt(receiveData(svSocket));
        sendData("Nhập số thứ hai: ", svSocket, IPAddress, port);
        num2 = Integer.parseInt(receiveData(svSocket));
        String add, sub;
        add = "Tổng hai số là " + (num1 + num2);
        sub = "Hiệu của số thứ 1 cho số thứ 2 là "+ (num1- num2);
        sendData(add, svSocket, IPAddress, port);
        sendData(sub, svSocket, IPAddress, port);
        svSocket.close();
    }
}
