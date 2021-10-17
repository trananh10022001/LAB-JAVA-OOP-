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
public class Fresher extends Candidate {
 private int graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(int id, String firstName, String lastName, int birthDate, 
            String address, String phone, String email, int type,int graduationDate, String graduationRank, String education) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return super.toString() + graduationDate + "\t" + graduationRank + "\t" + education;
    }
    
    
    
}
