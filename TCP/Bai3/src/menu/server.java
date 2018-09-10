/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author quang
 */
public class server {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(9999);
        Socket srs = ss.accept();
        DataInputStream din = new DataInputStream(srs.getInputStream());
        DataOutputStream dout = new DataOutputStream(srs.getOutputStream());
        int a = 0, b = 0, c;
        boolean flag = false;
        boolean check = true;
        String d;
        while(check){
            c = din.readInt();
            if(c == 1){
                flag = true;
            }
            dout.writeBoolean(flag);
            while(c != 1 && flag == false){
                c = din.readInt();
                if(c == 1){
                    flag = true;
                }
                dout.writeBoolean(flag);
            }
            switch(c){
                case 1:{
                    a = din.readInt();
                    b = din.readInt();
                    break;
                }
                case 2:{
                    d = "Tong la " + (a + b);
                    System.out.println(d);
                    dout.writeUTF(d);
                    break;
                }
                case 3:{
                    d = "Tich la " + (a*b);
                    System.out.println(d);
                    dout.writeUTF(d);
                    break;
                }
                default:{
                    din.close();
                    dout.close();
                    srs.close();
                    ss.close();
                    check = false;
                    break;
                }
            }
        }
    }
}
