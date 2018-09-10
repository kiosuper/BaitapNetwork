/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Socket cl = new Socket("localhost", 9999);
        DataInputStream din = new DataInputStream(cl.getInputStream());
        DataOutputStream dout = new DataOutputStream(cl.getOutputStream());
        System.out.println("Connected");
        int num1, num2;
        System.out.print("Nhap so thu nhat: ");
        num1 = sc.nextInt();
        System.out.print("Nhap so thu hai: ");
        num2 = sc.nextInt();
        dout.writeInt(num1);
        dout.writeInt(num2);
        String stadd, stsub;
        stadd = din.readUTF();
        stsub = din.readUTF();
        System.out.println(stadd);
        System.out.println(stsub);
        System.out.println("Disconnected");
        din.close();
        dout.close();
        cl.close();
    }
    
}
