/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author tungs
 */
public class Candidate {

    public enum CandidateType {
        Experience, Fresher, Intern;

        public int getIntValue() {
            switch (this) {
                case Experience:
                    return 0;
                case Fresher:
                    return 1;
                case Intern:
                    return 2;
            }
            throw new IndexOutOfBoundsException("Invalid Value");
        }
        
        public static CandidateType getTypeByInt(int type) {
            switch (type) {
                case 0:
                    return Experience;
                case 1:
                    return Fresher;
                case 2:
                    return Intern;
            }
            throw new IndexOutOfBoundsException("Invalid Value");
        }
    }
    private int id;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private String phone;
    private String email;
    private CandidateType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) throws Exception {
        if (LocalDateTime.now().getYear()-birthDate<15) {
            throw new Exception("You must be over 15 year old");
        }
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CandidateType getType() {
        return type;
    }

    public void setType(CandidateType type) {
        this.type = type;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return String.format("\n%-5s|%-20s %-20s | %-4s | %-30s | %-20s | %-30s | %-1s\n", id, firstName, lastName, birthDate + "", address, phone, email, type.getIntValue() + "");
    }
    
    

}
