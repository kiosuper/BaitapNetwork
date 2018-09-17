/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;

/**
 *
 * @author quang
 */
public class server {
    /**
     * @param args the command line arguments
     */
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
        Random rand = new Random();
        int n = rand.nextInt(10) + 1;
        int num;
        boolean flag = true;
        while(flag != false){
            sendData("Đoán xem? ", svSocket, IPAddress, port);
            num = Integer.parseInt(receiveData(svSocket));
            if(num == n){
                flag = false;
                sendData("Bạn đã đoán đúng số rồi.", svSocket, IPAddress, port);
            }
            else if(num > n){
                sendData("Số bạn đoán lớn quá.", svSocket, IPAddress, port);
            }
            else{
                sendData("Số bạn đoán nhỏ quá.", svSocket, IPAddress, port);
            }
            if(flag == true){
                sendData("1", svSocket, IPAddress, port);
            }
            else{
                sendData("0", svSocket, IPAddress, port);
            }
        }
        svSocket.close();
    }
    
}
