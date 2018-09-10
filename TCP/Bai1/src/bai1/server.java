/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(9999);
        Socket srs = ss.accept();
        DataInputStream din = new DataInputStream(srs.getInputStream());
        DataOutputStream dout = new DataOutputStream(srs.getOutputStream());
        int num1, num2, add, sub;
        num1 = din.readInt();
        num2 = din.readInt();
        add = num1 + num2;
        sub = num1 - num2;
        String stadd, stsub;
        stadd = "Tong cua " + num1 + " va " + num2 + " la: " + add;
        stsub = "Hieu cua " + num1 + " va " + num2 + " la: " + sub;
        dout.writeUTF(stadd);
        dout.writeUTF(stsub);
        din.close();
        dout.close();
        srs.close();
        ss.close();
        
    }
}
