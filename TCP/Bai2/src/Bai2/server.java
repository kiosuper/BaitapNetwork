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
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(9999);
        Socket srs = ss.accept();
        DataInputStream din = new DataInputStream(srs.getInputStream());
        DataOutputStream dout = new DataOutputStream(srs.getOutputStream());
        
        Random rd = new Random();
        int a = rd.nextInt(100);
        int b;
        String d;
        boolean check = true;
        System.out.println(a);
        while(check){
            b = din.readInt();
            if(b == a){
                d = "Ban da doan dung so.";
                check = false;
                dout.writeUTF(d);
            }
            else if(b > a){
                d = "So ban vua doan lon hon so muc tieu.";
                dout.writeUTF(d);
            }
            else{
                d = "So ban vua doan nho hon so muc tieu.";
                dout.writeUTF(d);
            }
        }
    }
}
