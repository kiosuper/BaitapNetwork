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
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author quang
 */
public class client {

    /**
     * @param args the command line arguments
     */
    public static void sendData(String data, DatagramSocket clSocket, InetAddress IPAddress, int port) throws IOException{
        byte[] sendData = new byte[1024];
        sendData = data.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        clSocket.send(sendPacket);
    }
    
    public static String receiveData(DatagramSocket clSocket, InetAddress IPAddress, int port) throws IOException{
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clSocket.receive(receivePacket);
        String sentence = new String(receivePacket.getData());
        return sentence.trim();
    }
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        DatagramSocket clSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        int port = 1234;
        byte[] sendData = new byte[1024];
        String sentence = "Connected.";
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        clSocket.send(sendPacket);
        System.out.print(receiveData(clSocket, IPAddress, port));
        num1 = sc.nextInt();
        sendData(Integer.toString(num1), clSocket, IPAddress, port);
        System.out.print(receiveData(clSocket, IPAddress, port));
        num2 = sc.nextInt();
        sendData(Integer.toString(num2), clSocket, IPAddress, port);
        System.out.println(receiveData(clSocket, IPAddress, port));
        System.out.println(receiveData(clSocket, IPAddress, port));
        clSocket.close();
    }
    
}
