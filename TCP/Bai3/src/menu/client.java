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
        DataOutputStream dout = new DataOutputStream(cl.getOutputStream());
        DataInputStream din = new DataInputStream(cl.getInputStream());
        boolean flag = false;
        boolean check = true;
        int num1 = 0, num2 = 0, c;
        while(check){
            System.out.print(din.readUTF());
            c = sc.nextInt();
            dout.writeInt(c);
            flag = din.readBoolean();
            while(flag == false){
                System.out.print(din.readUTF());
                c = sc.nextInt();
                dout.writeInt(c);
                flag = din.readBoolean();
            }
            switch(c){
                case 1:{
                    System.out.print(din.readUTF());
                    num1 = sc.nextInt();
                    dout.writeInt(num1);
                    System.out.print(din.readUTF());
                    num2 = sc.nextInt();
                    dout.writeInt(num2);
                    break;
                }
                case 2:{
                    System.out.println(din.readUTF());
                    break;
                }
                case 3:{
                    System.out.println(din.readUTF());
                    break;
                }  
                default:{
                    check = din.readBoolean();
                    din.close();
                    dout.close();
                    cl.close();
                }
            }
        }
    }
}
