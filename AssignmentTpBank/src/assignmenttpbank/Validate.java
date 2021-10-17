/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttpbank;

import java.util.Scanner;

/**
 *
 * @author ASUS ROG
 */
public class Validate {
       
    //Hàm Lấy 1 số nguyên 
    //Nếu nhập vào không phải số nguyên thì nhập lại
    Scanner sc = new Scanner(System.in);

    public int getInt(String msg, String err, int min, int max) {
        int num;

        while (true) {
            try {
                System.out.println(msg);
                num = Integer.parseInt(sc.nextLine());

                //num là số nguyên
                //kiểm tra xem có nằm trong [min,max]
                if (num < min || num > max) {
                    System.out.println(err);
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.out.println(err);
            }

        }
    }

    public String getString(String msg, String err, String regex) { //Kiểm tra chuỗi nhập vào có khớp với định dạng mong muốn hay không
        String s;
        while (true) {
            System.out.println(msg);
            s = sc.nextLine();
            
            if(s.trim().equals("")){
                continue;
            }
            //kiểm tra s với định dạng regex
            if (!s.matches(regex)) {
                System.out.println(err);
                continue;
            }
            return s.trim();
        }
    }
}
