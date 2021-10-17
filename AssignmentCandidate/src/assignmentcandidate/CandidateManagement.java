/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcandidate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ASUS ROG
 */
public class CandidateManagement {

    ArrayList<Candidate> listCadidate = new ArrayList<>();
    Validate validate = new Validate();

    public void CandidateManage() {
        listCadidate.add(new Experience(1, "Binh", "Duc", 1988, "Ha Noi", "0928384912", "ducbinh@fpt.edu.vn", 0, 2, "C"));
        listCadidate.add(new Experience(2, "Thuong", " Ngoc", 2000, "Ha Noi", "0213384912", "ngocthuong@fpt.edu.vn", 0, 2, "Java"));
        listCadidate.add(new Fresher(3, "Anh", "Duc", 2001, "Hung Yen", "0928384912", "ducanh@fpt.edu.vn", 1, 2020, "Good", "University"));
        listCadidate.add(new Fresher(4, "Anh", "Tran", 2001, "Ha Noi", "0898384912", "anhtran@fpt.edu.vn", 1, 2021, "Excellence", "University"));
        listCadidate.add(new Intern(5, "Hong", "Ngoc", 2003, "Ninh Binh", "0928384912", "hongngoc@fpt.edu.vn", 2, "Information System", 7, "FPT University"));
        
    }

    //id tu tang , khong can nhap id(Để tránh duplicate primary key)
    void addCandidate(int TYPE_EXPERIENCE) {
        int id = 1;
        if (!listCadidate.isEmpty()) {
            id = listCadidate.get(listCadidate.size() - 1).getId() + 1;//Bằng id cuối cùng + 1
        }

        String firstName = validate.getString("Enter First name: ", "First name invalid", "[a-zA-Z ]+");
        String lastName = validate.getString("Enter Last name: ", "Last name invalid", "[a-zA-Z ]+");
        int yearNow = Calendar.getInstance().get(Calendar.YEAR);
        int birthDate = validate.getInt("Enter Birth Date: ", "Birth Date [1900-now]: ", 1900, yearNow);
        String address = validate.getString("Enter Address: ", "Address Invalid", "[a-zA-Z0-9 -/]+");
        String phone = validate.getString("Enter Phone: ", "Phone is number with minimum 10 characters", "[0-9]{10,}");

        String email = validate.getString("Enter Email: ",
                "Email with format <account name>@<domain>",
                "^(([a-zA-Z0-9]+)@([a-zA-Z0-9]+\\,)*([a-zA-Z0-9]+))$");
        int type = validate.getInt("Enter type of cadidate: ", "Type[0-2]", 0, 2);

        Candidate candidate;
        switch (type) {
            case TypeOfCandidate.TYPE_EXPERIENCE:
                int expInYear = validate.getInt("Enter experience in year: ", "year[0-100]", 0, 100);
                String proSkill = validate.getString("Enter Pro Skill: ", "Pro Skill invalid", "[a-zA-Z]+");
                candidate = new Experience(id, firstName, lastName, birthDate, address, phone, email, type, expInYear, proSkill);

                break;
            case TypeOfCandidate.TYPE_FRESHER:
                int graduationDate = validate.getInt("Enter Graduation Date: ", "Year[1900-now]", 1900, yearNow);
                String rank = validate.getString("Enter Rank: ", "with one of 4 values (excellence, good, fair, poor)", "(Excellence)|(Good)|(Fair)|(Poor)");
                String education = validate.getString("Enter Education: ", "Education Invalid", "[a-zA-Z ]+");
                candidate = new Fresher(id, firstName, lastName, birthDate, address, phone, email, type, graduationDate, rank, education);

                break;
            default:
                String major = validate.getString("Enter Major: ", "Major Invalid", "[a-zA-Z ]+");
                int semester = validate.getInt("Enter Semester: ", "Semester[1-9]", 1, 9);
                String university = validate.getString("Enter University : ", "University Invalid", "[a-zA-Z]+");
                candidate = new Intern(id, firstName, lastName, birthDate, address, phone, email, type, major, semester, university);

                break;
        }
        listCadidate.add(candidate);
        display();
    }

    void display() {

        for (Candidate candidate : listCadidate) {
            System.out.println(candidate);
        }
    }

    void search() {
        displayAll();
        String inputSearch = validate.getString("Input Candidate name (First name or Last name):", "Keyword invalid", "[a-zA-Z ]+");
        int type = validate.getInt("Input type of candidate: ", "Type [0-2]", 0, 2);

        for (Candidate C : listCadidate) {
            if (C.getType() == type) {
                String fullName = C.getFirstName().toLowerCase() + C.getLastName().toLowerCase();
                if (fullName.contains(inputSearch.toLowerCase())) {
                    System.out.println(C);
                }
            }
        }
    }

    public void displayAll() {
 /*       System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate C : listCadidate) {
            if (C instanceof Experience) {
                System.out.println(C.getFirstName() + " " + C.getLastName());
            }
        }

        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate C : listCadidate) {
            if (C instanceof Fresher) {
                System.out.println(C.getFirstName() + " " + C.getLastName());
            }
        }

        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate C : listCadidate) {
            if (C instanceof Intern) {
                System.out.println(C.getFirstName() + " " + C.getLastName());
            }
        }
    }*/

    //C2:
    // Sap xep tang dan theo type 
       Collections.sort(listCadidate, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
               return o1.getType()-o2.getType();
            }
        });
        System.out.println("===========EXPERIENCE CANDIDATE============");
        // Dùng biến instance để có thể in ra cái title duy nhất 1 lần trong suốt việc in list
        int instance = 0;
        for (Candidate C : listCadidate) { 
            
            if(C.getType()==1&&instance==0){
                System.out.println("==========FRESHER CANDIDATE==============");
                instance=1;
            }
            if(C.getType()==2&&instance==1){
                System.out.println("==========INTERN CANDIDATE==============");
                instance=2;
            }
           System.out.println(C.getFirstName()+" "+C.getLastName());
        }
     
}
}
