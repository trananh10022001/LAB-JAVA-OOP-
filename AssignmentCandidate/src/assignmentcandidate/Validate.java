/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcandidate;

/**
 *
 * @author ASUS ROG
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author ASUS ROG
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public int getInt(String msg, String err, int min, int max) {
        int num;

        while (true) {
            try {
                System.out.println(msg);
                num = Integer.parseInt(sc.nextLine());
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

    public String getString(String msg, String err, String regex) { // Kiem tra chuoi nhap vao co khop voi dinh dang mong muon khong
        String s;
        while (true) {
            System.out.println(msg);
            s = sc.nextLine();
            if (s.trim().equals("")) {
                continue;
            }
            
            if (!s.matches(regex)) {
                System.out.println(err);
                continue;
            }
          s = chuanHoa(s);
          return s;
    }
      
    }
  
 
    public String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        String temp[] = str.split(" ");
        str = ""; 
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) 
                str += " ";
        }
        return str;
       
    }
    
}
