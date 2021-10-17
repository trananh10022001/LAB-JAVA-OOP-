/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorversion2;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DoctorManagement {

    List<Doctor> listDoctor = new ArrayList<>();
    Validate validate = new Validate();

    public int indexCode(String code) {
        for (int i = 0; i < listDoctor.size(); i++) {
            if (listDoctor.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public void addDoctor() {
        listDoctor = FileProcess.getAllDoctor();
        String code;
        do{
            code = validate.getString("Enter Code: ", "[a-zA-Z 0-9]+");
            if(indexCode(code)!=-1){
                System.out.println("Code is exist.");
            }
        }while(indexCode(code)!=-1);
        
        String name = validate.getString("Enter Name: ", "[a-zA-Z ]+");
        String specialization = validate.getString("Enter Specialization: ", "[a-zA-Z ]+");
        int availability = validate.getInt("Enter Availability: ", "Availability is a positive integer", 1, Integer.MAX_VALUE);
        Doctor doctor = new Doctor(code, name, specialization, availability);
        listDoctor.add(doctor);
        FileProcess.saveAllDoctor(listDoctor);
    }
    
    public void updateDoctor(){
        listDoctor=FileProcess.getAllDoctor();
        
        String code =validate.getString("Enter Code: ", "[a-zA-Z 0-9]+");
        int indexCode = indexCode(code);
        if(indexCode==-1){
            System.out.println("Doctor code does not exist");
        }else{
            //update
            String name = validate.getString("Enter Name: ", "[a-zA-Z ]*");
            if(!name.trim().equals("")){
                listDoctor.get(indexCode).setName(name);
            }
            String specialization = validate.getString("Enter Specialization: ", "[a-zA-Z ]*");
            if(!specialization.trim().equals("")){
                listDoctor.get(indexCode).setSpecialization(specialization);
            }
            
            String availability = validate.getString("Enter Availability", "[0-9]*");
            if(!availability.trim().equals("")){
                listDoctor.get(indexCode).setAvailability(Integer.parseInt(availability));
            }
            
            FileProcess.saveAllDoctor(listDoctor);
        }
    }
    public void deleteDoctor(){
        listDoctor=FileProcess.getAllDoctor();
        String code =validate.getString("Enter Code: ", "[a-zA-Z 0-9]+");
        int indexCode = indexCode(code);
        if(indexCode==-1){
            System.out.println("Doctor code does not exist");
        }else{
            //Xoa
            listDoctor.remove(indexCode);
            FileProcess.saveAllDoctor(listDoctor);
        }
    }
    public void search(){
        System.out.println("---------- Search Doctor --------");
        String key = validate.getString("Enter text:", "[a-zA-Z 0-9]+");
        
        for (Doctor D : listDoctor) {
            String fullText = D.getCode()+D.getName()+D.getSpecialization();
            
            if(fullText.toLowerCase().contains(key.toLowerCase())){
                System.out.println(D);
            }
        }
    }
    
    public void DisplayAllDoctor(){
        System.out.println("---------- Diplay All Doctor --------");
        System.out.format("%20s%20s%20s%20s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor D : listDoctor) {
            System.out.println(D);
        }
    }

    
}
