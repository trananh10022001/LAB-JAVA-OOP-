/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandyexpense;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS ROG
 */
public class Expense_Management {
        Validate validate = new Validate();
        ArrayList<Expense> listExpense = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
    void addExpense() {
        int id=1;
        if(!listExpense.isEmpty()){
            id = listExpense.get(listExpense.size()-1).getID()+1;
        }
        Date date = validate.getDate("Enter date: ", "Date invalid", "dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        double amount = validate.getDouble("Enter amount of money: ", "Amount is double value", Double.MIN_VALUE, Double.MAX_VALUE);
        System.out.println("Enter content: ");
        String content = sc.nextLine();
        Expense E = new Expense(id, sdf.format(date), amount, content);
        listExpense.add(E);
        
    }

    void displayExpense() {
        System.out.format("%20s%20s%20s%20s\n", "ID","Date","Amount Of Money","Content");
        double totalMoney=0;
        for (Expense expense : listExpense) {
            System.out.println(expense.toString());
            totalMoney+=expense.getNumber();
        }
        System.out.println("Total: "+totalMoney);
        
    }

    void deleteExpense() {
       //Nhap id
        int idDelete = validate.getInt("Enter ID: ", "ID is  an integer number", 1, Integer.MAX_VALUE);
       //Tim id xem co ton tai khong
       boolean isIdExist = false;
       for(int i=0;i<listExpense.size();i++){
           //Neu tim thay id nhap tu ban phim
           if(listExpense.get(i).getID()== idDelete){
               //Xoa expense o vi tri i di
               listExpense.remove(i);
               isIdExist = true;
               break;
           }
       }
       //Neu ko ton tai thi in loi
       if(!isIdExist){
           System.out.println("Delete an expense fail");
       }
    }
    
}
