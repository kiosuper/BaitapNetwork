/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.io.*;
import java.net.*;
/**
 *
 * @author quang
 */
public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        Socket srs = ss.accept();
        DataInputStream din = new DataInputStream(srs.getInputStream());
        DataOutputStream dout = new DataOutputStream(srs.getOutputStream());
        int num1 = 0, num2 = 0, c;
        String menu = "1.Nhập 2 số.\n2.Tổng 2 số.\n3.Tích 2 số.\n4.Thoát.\nNhập lựa chọn: ";
        boolean flag = false;
        boolean check = true;
        while(check){
            dout.writeUTF(menu);
            c = din.readInt();
            if(c == 1){
                flag = true;
            }
            dout.writeBoolean(flag);
            while(c != 1 && flag == false){
                dout.writeUTF("Chưa có số trong dữ liệu để thực hiện tính. Vui lòng chọn 1 để thực hiện nhập số.\n" + menu);
                c = din.readInt();
                if(c == 1){
                    flag = true;
                }
                dout.writeBoolean(flag);
            }
            switch(c){
                case 1:{
                    dout.writeUTF("Số thứ nhất: ");
                    num1 = din.readInt();
                    dout.writeUTF("Số thứ hai: ");
                    num2 = din.readInt();
                    break;
                }
                case 2:{
                    dout.writeUTF("Tổng là " + (num1 + num2));
                    break;
                }
                case 3:{
                    dout.writeUTF("Tích là " + (num1*num2));
                    break;
                }
                default:{
                    check = false;
                    dout.writeBoolean(check);
                    din.close();
                    dout.close();
                    srs.close();
                    ss.close();
                    break;
                }
            }
        }
    }
}
