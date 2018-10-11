/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        Socket srs = ss.accept();
        DataInputStream din = new DataInputStream(srs.getInputStream());
        DataOutputStream dout = new DataOutputStream(srs.getOutputStream());
        Random rd = new Random();
        int rand = rd.nextInt(100);
        int num_guess;
        boolean check = true;
        System.out.println(rand);
        while(check){
            dout.writeUTF("Số mà bạn đoán là: ");
            num_guess = din.readInt();
            if(num_guess == rand){
                check = false;
                dout.writeUTF("Bạn đã đoán chính xác số bí mật.");
            }
            else if(num_guess > rand){
                dout.writeUTF("Số bạn vừa đoán lớn hơn số bí mật.");
            }
            else{
                dout.writeUTF("Số bạn vừa đoán nhỏ hơn số bí mật.");
            }
            dout.writeBoolean(check);
        }
    }
}
