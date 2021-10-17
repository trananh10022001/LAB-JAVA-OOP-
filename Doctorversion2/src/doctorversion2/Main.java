/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorversion2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Main {

    public static void main(String[] args) {
        DoctorManagement manager = new DoctorManagement();
        manager.listDoctor.add(new Doctor("Doc 1", "name1", "ABC", 3));
        manager.listDoctor.add(new Doctor("Doc 2", "name2", "DEF", 4));
        manager.listDoctor.add(new Doctor("Doc 3", "name3", "GHI", 1));
        manager.listDoctor.add(new Doctor("Doc 4", "name4", "JQK", 2));

        manager.DisplayAllDoctor();
        Validate validate = new Validate();

        boolean loop = true;
        while (loop) {
            System.out.println("========= Doctor Management ==========\n"
                    + "1.	Add Doctor\n"
                    + "2.	Update Doctor\n"
                    + "3.	Delete Doctor\n"
                    + "4.	Search Doctor\n"
                    + "5.	Exit");
            int option = validate.getInt("Enter Your Option: ", "Option [1-5]", 1, 5);

            switch (option) {
                case 1:
                    manager.addDoctor();
                    manager.DisplayAllDoctor();
                    break;
                case 2:
                    manager.updateDoctor();
                    manager.DisplayAllDoctor();
                    break;
                case 3:
                    manager.deleteDoctor();
                    manager.DisplayAllDoctor();
                    break;
                case 4:
                    manager.search();
                    break;
                case 5:
                    loop = false;
                    break;
            }
        }
    }
}
