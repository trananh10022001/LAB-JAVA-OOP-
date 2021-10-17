/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandyexpense;

/**
 *
 * @author ASUS ROG
 */
public class main {

    public static void main(String[] args) {
        Expense_Management manager = new Expense_Management();
        Validate validate = new Validate();
        while (true) {
            System.out.println("1. Add an expense\n"
                    + "2. Display all expenses\n"
                    + "3. Remove an expense\n"
                    + "4. Exit");
            int option = validate.getInt("Enter your option: ", "Option[1-4}, Try again!", 1, 4);
            switch (option) {
                case 1:
                    manager.addExpense();
                    break;
                case 2:
                    manager.displayExpense();
                    break;
                case 3:
                    manager.deleteExpense();
                    break;
                case 4:
                    break;
            }
        }
    }

}
