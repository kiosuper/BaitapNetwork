/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author quang
 */
public class client {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Socket cl = new Socket("localhost", 9999);
        DataInputStream din = new DataInputStream(cl.getInputStream());
        DataOutputStream dout = new DataOutputStream(cl.getOutputStream());
        
        String menu, sub_menu;
        boolean flag, check, sub_check;
        int choose, num1, num2, num3;
        System.out.println(din.readUTF());
        check = din.readBoolean();
        while(check){
            menu = din.readUTF();
            System.out.print(menu);
            choose = sc.nextInt();
            dout.writeInt(choose);
            switch(choose){
                case 1:
                    sub_check=din.readBoolean();
                    flag = din.readBoolean();
                    while(sub_check){
                        sub_menu=din.readUTF();
                        System.out.print(sub_menu);
                        choose = sc.nextInt();
                        dout.writeInt(choose);
                        while(flag == false){
                            if(choose == 1 || choose > 2){
                                flag = din.readBoolean();
                            }
                            else if(choose == 2){
                                flag = din.readBoolean();
                                sub_menu = din.readUTF();
                                System.out.print(sub_menu);
                                choose = sc.nextInt();
                                dout.writeInt(choose);
                            }
                        }
                        switch(choose){
                            case 1:
                                System.out.print(din.readUTF());
                                num1 = sc.nextInt();
                                dout.writeInt(num1);
                                break;
                            case 2:
                                System.out.println(din.readUTF());
                                break;
                            default:
                                sub_check=din.readBoolean();
                                break;
                        }
                    }
                    break;
                case 2:
                    sub_check=din.readBoolean();
                    flag = din.readBoolean();
                    while(sub_check){
                        sub_menu=din.readUTF();
                        System.out.print(sub_menu);
                        choose = sc.nextInt();
                        dout.writeInt(choose);
                        while(flag == false){
                            if(choose == 1 || choose > 2){
                                flag = din.readBoolean();
                            }
                            else if(choose == 2){
                                flag = din.readBoolean();
                                sub_menu = din.readUTF();
                                System.out.print(sub_menu);
                                choose = sc.nextInt();
                                dout.writeInt(choose);
                            }
                        }
                        switch(choose){
                            case 1:
                                System.out.print(din.readUTF());
                                num1 = sc.nextInt();
                                dout.writeInt(num1);
                                System.out.print(din.readUTF());
                                num2 = sc.nextInt();
                                dout.writeInt(num2);
                                break;
                            case 2:
                                System.out.println(din.readUTF());
                                break;
                            default:
                                sub_check=din.readBoolean();
                                break;
                        }
                    }
                    break;
                case 3:
                    sub_check=din.readBoolean();
                    flag = din.readBoolean();
                    while(sub_check){
                        sub_menu=din.readUTF();
                        System.out.print(sub_menu);
                        choose = sc.nextInt();
                        dout.writeInt(choose);
                        while(flag == false){
                            if(choose == 1 || choose > 3){
                                flag = din.readBoolean();
                            }
                            else if(choose == 2 || choose == 3){
                                flag = din.readBoolean();
                                sub_menu = din.readUTF();
                                System.out.print(sub_menu);
                                choose = sc.nextInt();
                                dout.writeInt(choose);
                            }
                        }
                        switch(choose){
                            case 1:
                                System.out.print(din.readUTF());
                                num1 = sc.nextInt();
                                dout.writeInt(num1);
                                System.out.print(din.readUTF());
                                num2 = sc.nextInt();
                                dout.writeInt(num2);
                                System.out.print(din.readUTF());
                                num3 = sc.nextInt();
                                dout.writeInt(num3);
                                break;
                            case 2:
                                System.out.println(din.readUTF());
                                break;
                            case 3:
                                System.out.println(din.readUTF());
                                break;
                            default:
                                sub_check=din.readBoolean();
                                break;
                        }
                    }
                    break;
                default:
                    check = din.readBoolean();
                    System.out.println(din.readUTF());
                    din.close();
                    dout.close();
                    cl.close();
                    break;
            }
        }
    }
}
