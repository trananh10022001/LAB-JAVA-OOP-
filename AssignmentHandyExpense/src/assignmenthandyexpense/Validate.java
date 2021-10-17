/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandyexpense;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS ROG
 */
public class Validate {
    public int getInt(String msg, String err,int min,int max){
        int num;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try{
                System.out.println(msg);
                num = Integer.parseInt(sc.nextLine());
                if(num<min || num>max){
                    System.out.println(err);
                    continue;
                }
                return num;
            }
        catch(Exception e){
            System.out.println(err);
        }
    }
}
    
     public double getDouble(String msg, String err,double min,double max){
        double num;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try{
                System.out.println(msg);
                num = Double.parseDouble(sc.nextLine());
                if(num<min || num>max){
                    System.out.println(err);
                    continue;
                }
                return num;
            }
        catch(Exception e){
            System.out.println(err);
        }
    }
}
    public Date getDate(String msg, String err,String format){//Nhan vao mot ngay voi dinh dang mong muon
          Date date = null;
          Scanner sc = new Scanner(System.in);
          SimpleDateFormat sdf = new SimpleDateFormat(format);
          sdf.setLenient(false);
          while(true){
              try {
                  System.out.println(msg);
                 date = sdf.parse(sc.nextLine());//Neu parse dc sang date thi return con nguoc lai thi in ra error
                  return date;
              } catch (Exception e) {
                  System.out.println(err);
              }
          }
    }
}
