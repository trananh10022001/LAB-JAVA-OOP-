/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttpbank;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author ASUS ROG
 */
public class Main {

    public static Validate validate = new Validate();
    public static Scanner sc = new Scanner(System.in);

    public static void login(ResourceBundle bundle) {
        String account = checkAcount(bundle);
        checkPassword(bundle);
        checkCapcha(bundle);
        System.out.println(bundle.getString("success"));
        System.out.println("Accout: " + account);
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Vietnamese\n"
                    + "2. English\n"
                    + "3. Exit");
            int option = validate.getInt("Enter your option: ", "Option[1-3]", 1, 3);
            ResourceBundle bundle;
            switch (option) {
                case 1:
                    bundle = ResourceBundle.getBundle("assignmenttpbank.language_vi_VN");
                    login(bundle);
                    break;
                case 2:
                    bundle = ResourceBundle.getBundle("assignmenttpbank.language_en_US");
                    login(bundle);
                    break;
                case 3:
                    break;
            }
        }
    }

    private static String checkAcount(ResourceBundle bundle) {
        String account = validate.getString(bundle.getString("account"), bundle.getString("account.wrong"), "[0-9]{10}");
        return account;
    }

    private static void checkPassword(ResourceBundle bundle) {
        String password;
        while (true) {
            System.out.println(bundle.getString("password"));
            password = sc.nextLine();
            if (!password.matches("^[a-zA-Z0-9]{6,12}$")//mật khẩu có thể là chữ , số , và độ dài từ 6-12 kí tự
                    || !password.matches("^[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*$")//Tồn tại ít nhất 1 chữ
                    || !password.matches("^[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*$")) { //tồn tại ít nhất 1 số

                System.out.println(bundle.getString("password.wrong"));
                continue;
            }
            break;
        }
    }

    private static String randomCapcha() {//tạo 1 capcha có độ dài bằng 5
        Random rand = new Random();
        String s = "";
        for (char i = 'a'; i <= 'z'; i++) {
            s = s + i;
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            s = s + i;
        }
        for (int i = 0; i <= 9; i++) {
            s = s + i;
        }
        String capcha = "";
        for (int i = 0; i < 5; i++) {
            int indexRandom = rand.nextInt(s.length());
            capcha += s.charAt(indexRandom);
        }
        return capcha;
    }

    private static void checkCapcha(ResourceBundle bundle) {
        while (true) {
            String capcha = randomCapcha();
            System.out.println("Capcha: " + capcha);
            String input = validate.getString(bundle.getString("capcha"), bundle.getString("capcha.invalid"), "[a-zA-z0-9]{5}");

            if (!input.equals(capcha)) {
                System.out.println(bundle.getString("capcha.wrong"));
                continue;
            }
            break;
        }

    }
}
