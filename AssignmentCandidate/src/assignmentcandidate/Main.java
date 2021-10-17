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
public class Main {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        CandidateManagement manager = new CandidateManagement();
        Validate validate = new Validate();
        manager.CandidateManage();
        manager.display();
        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM\n"
                    + "1."
                    + "Experience\n"
                    + "2."
                    + "Fresher\n"
                    + "3."
                    + "Internship\n"
                    + "4."
                    + "Searching\n"
                    + "5."
                    + "Exit");
            int option = validate.getInt("Enter your option: ", "Option [1-5]", 1, 5);
            switch(option){
                case 1:
                    manager.addCandidate(TypeOfCandidate.TYPE_EXPERIENCE);
                    break;
                case 2: 
                    manager.addCandidate(TypeOfCandidate.TYPE_FRESHER);
                    break;
                case 3: 
                     manager.addCandidate(TypeOfCandidate.TYPE_INTERN);
                     break;
                case 4:
                    manager.search();
                    break;
                case 5: 
                    break;
            }
        }
    }
}
