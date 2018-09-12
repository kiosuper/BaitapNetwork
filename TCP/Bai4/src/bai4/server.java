/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author quang
 */

public class server {
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static String commonDivisor(int num1, int num2){
        int n;
        String s ="Các ước số của " + Integer.toString(num1) + " và " + Integer.toString(num2) +" là:";
        if(num1 < num2){
            n = num1;
        }
        else{
            n = num2;
        }
        for(int i = 1; i <= n; i++){
            if(num1 % i == 0 && num2 % i == 0){
                s += " "+Integer.toString(i);
            }
        }
        return s;
    }
    
    public static String maxOutput(int num1, int num2, int num3){
        String s = "Max là ";
        int max = num1;
        if(max < num2){
            max = num2;
        }
        else if(max < num3){
            max = num3;
        }
        return s + Integer.toString(max);
    }
    
    public static String minOutput(int num1, int num2, int num3){
        String s = "Min là ";
        int min = num1;
        if(min > num2){
            min = num2;
        }
        else if(min > num3){
            min = num3;
        }
        return s + Integer.toString(min);
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket ss = new ServerSocket(9999);
        Socket srs = ss.accept();
        DataInputStream din = new DataInputStream(srs.getInputStream());
        DataOutputStream dout = new DataOutputStream(srs.getOutputStream());
        
        String menu, menu1, menu2, menu3;
        menu = "1.Tìm số nguyên tố.\n2.Tìm ước số.\n3.Tìm Max và Min.\n4.Thoát\nNhập lựa chọn: ";
        menu1 = "1.Nhập 1 số.\n2.Xác định số nguyên tố.\n3.Thoát\nNhập lựa chọn: ";
        menu2 = "1.Nhập 2 số.\n2.In các Ước số.\n3.Thoát\nNhập lựa chọn: ";
        menu3 = "1.Nhập 3 số.\n2.In Max.\n3.In Min.\n4.Thoát\nNhập lựa chọn: ";
        boolean flag, check = true, sub_check;
        int choose, num1 = 0, num2 = 0, num3 = 0;
        dout.writeUTF("Connect.");
        dout.writeBoolean(check);
        while(check){
            dout.writeUTF(menu);
            choose = din.readInt();
            switch(choose){
                case 1:
                    sub_check = true;
                    flag = false;
                    dout.writeBoolean(sub_check);
                    dout.writeBoolean(flag);
                    while(sub_check){
                        dout.writeUTF(menu1);
                        choose = din.readInt();
                        while(flag == false){
                            if(choose == 1 || choose > 2){
                                flag = true;
                                dout.writeBoolean(flag);
                            }
                            else if(choose == 2){
                                dout.writeBoolean(flag);
                                dout.writeUTF("Bạn chưa nhập số. Vui lòng chọn 1 để nhập số.\n"+menu1);
                                choose = din.readInt();
                            }
                        }
                        switch(choose){
                            case 1:
                                dout.writeUTF("Nhập số: ");
                                num1 = din.readInt();
                                break;
                            case 2:
                                if(isPrimeNumber(num1)){
                                    dout.writeUTF(num1+" là số nguyên tố.");
                                }
                                else{
                                   dout.writeUTF(num1+" không là số nguyên tố."); 
                                }
                                break;
                            default:
                                sub_check=false;
                                dout.writeBoolean(sub_check);
                                break;
                        }
                    }
                    break;
                case 2:
                    sub_check = true;
                    flag = false;
                    dout.writeBoolean(sub_check);
                    dout.writeBoolean(flag);
                    while(sub_check){
                        dout.writeUTF(menu2);
                        choose = din.readInt();
                        while(flag == false){
                            if(choose == 1 || choose > 2){
                                flag = true;
                                dout.writeBoolean(flag);
                            }
                            else if(choose == 2){
                                dout.writeBoolean(flag);
                                dout.writeUTF("Bạn chưa nhập số. Vui lòng chọn 1 để nhập số.\n"+menu2);
                                choose = din.readInt();
                            }
                        }
                        switch(choose){
                            case 1:
                                dout.writeUTF("Nhập số thứ nhất: ");
                                num1 = din.readInt();
                                dout.writeUTF("Nhập số thứ hai: ");
                                num2 = din.readInt();
                                break;
                            case 2:
                                dout.writeUTF(commonDivisor(num1, num2));
                                break;
                            default:
                                sub_check=false;
                                dout.writeBoolean(sub_check);
                                break;
                        }
                    }
                    break;
                case 3:
                    sub_check = true;
                    flag = false;
                    dout.writeBoolean(sub_check);
                    dout.writeBoolean(flag);
                    while(sub_check){
                        dout.writeUTF(menu3);
                        choose = din.readInt();
                        while(flag == false){
                            if(choose == 1 || choose > 3){
                                flag = true;
                                dout.writeBoolean(flag);
                            }
                            else if(choose == 2 || choose == 3){
                                dout.writeBoolean(flag);
                                dout.writeUTF("Bạn chưa nhập số. Vui lòng chọn 1 để nhập số.\n"+menu3);
                                choose = din.readInt();
                            }
                        }
                        switch(choose){
                            case 1:
                                dout.writeUTF("Nhập số thứ nhất: ");
                                num1 = din.readInt();
                                dout.writeUTF("Nhập số thứ hai: ");
                                num2 = din.readInt();
                                dout.writeUTF("Nhập số thứ ba: ");
                                num3 = din.readInt();
                                break;
                            case 2:
                                dout.writeUTF(maxOutput(num1, num2, num3));
                                break;
                            case 3:
                                dout.writeUTF(minOutput(num1, num2, num3));
                                break;
                            default:
                                sub_check=false;
                                dout.writeBoolean(sub_check);
                                break;
                        }
                    }
                    break;
                default:
                    check = false;
                    dout.writeBoolean(check);
                    dout.writeUTF("Disconnect.");
                    din.close();
                    dout.close();
                    srs.close();
                    ss.close();
                    break;
            }
        }
    }
}