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
public class client {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Socket cl = new Socket("localhost", 9999);
        int a,b,c;
        boolean flag, check = true;
        String d;
        DataOutputStream dout = new DataOutputStream(cl.getOutputStream());
        DataInputStream din = new DataInputStream(cl.getInputStream());
        System.out.println("Connected.");
        while(check){
            System.out.println("1.Nhap 2 so.");
            System.out.println("2.Tong 2 so.");
            System.out.println("3.Tich 2 so.");
            System.out.println("4.Thoat.");
            System.out.print("Nhap lua chon: ");
            c = sc.nextInt();
            dout.writeInt(c);
            flag = din.readBoolean();
            while(flag == false){
                System.out.println("Ban chua nhap so. Vui long chon 1 de nhap so.");
                System.out.println("1.Nhap 2 so.");
                System.out.println("2.Tong 2 so.");
                System.out.println("3.Tich 2 so.");
                System.out.println("4.Thoat.");
                System.out.print("Nhap lua chon: ");
                c = sc.nextInt();
                dout.writeInt(c);
                flag = din.readBoolean();
            }
            switch(c){
                case 1:{
                    System.out.print("Nhap so thu nhat: ");
                    a = sc.nextInt();
                    System.out.print("Nhap so thu hai: ");
                    b =sc.nextInt();
                    dout.writeInt(a);
                    dout.writeInt(b);
                    break;
                }
                case 2:{
                    d = din.readUTF();
                    System.out.println(d);
                    break;
                }
                case 3:{
                    d = din.readUTF();
                    System.out.println(d);
                    break;
                }
                default:{
                    System.out.println("Disconnected.");
                    check = false;
                    din.close();
                    dout.close();
                    cl.close();
                    break;
                }
            }
        }
    }
}
