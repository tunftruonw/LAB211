/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.time.LocalDateTime;
import models.Candidate;
import models.Experience;
import models.Fresher;
import models.Intern;
import utils.TextUtility;

/**
 *
 * @author tungs
 */
public class CandidateInputer {

    private Candidate c;

    public Candidate getC() {
        return c;
    }

    public CandidateInputer(Candidate.CandidateType type) {
        switch (type) {
            case Experience:
                c = new Experience();
                break;
            case Fresher:
                c = new Fresher();
                break;
            case Intern:
                c = new Intern();
                break;
            default:
                throw new AssertionError();
        }
        c.setType(type);
    }

    private void inputCommonInfomation() {
        c.setFirstName(TextUtility.getStringByRegex("Enter First Name: ", "Please enter character only!", "[A-Za-z ]+"));
        c.setLastName(TextUtility.getStringByRegex("Enter Last Name: ", "Please enter character only!", "[A-Za-z ]+"));
        try {
            c.setBirthDate(TextUtility.getInt("Enter Birth Date: ", "Input number only!", "It must be >= 1900 and <= " + LocalDateTime.now().getYear(), 1900, LocalDateTime.now().getYear()));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        c.setAddress(TextUtility.getNonEmptyString("Enter Address: "));
        c.setPhone(TextUtility.getPhone(10, "Enter phone: "));
        c.setEmail(TextUtility.getEmail("Enter email: "));
    }

    private void inputFresherInformation() {
        inputCommonInfomation();
        ((Fresher) c).setGraduationDate(TextUtility.getInt("Enter your Graduation date: ", "Please enter number only", "Please enter between 1900 and " + LocalDateTime.now().getYear(), 1900, LocalDateTime.now().getYear()));
        ((Fresher) c).setEducation(TextUtility.getNonEmptyString("Enter your education: "));
        int rank = TextUtility.getInt("Enter your rank(1- Excellence, 2- Good,3- Fair, 4- Poor) : ", "Please enter number only", "Please enter number between 1-4", 1, 4);
        ((Fresher) c).setGraduationRank(Fresher.GraduationRank.getTypeByInt(rank));
    }

    private void inputExperienceInformation() {
        inputCommonInfomation();
        while (true) {
            try {
                ((Experience) c).setExpInYear(TextUtility.getInt("Enter your year of experience: ", "Number only", "Out of range", 0, 100));
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        ((Experience) c).setProSkill(TextUtility.getNonEmptyString("Enter your pro skill: "));
    }

    private void inputInternInformation() {
        inputCommonInfomation();
        ((Intern) c).setMajor(TextUtility.getNonEmptyString("Enter your major: "));
        ((Intern) c).setSemester(TextUtility.getInt("Enter your semester: ", "Number only", "Out of range", 1, 20));
        ((Intern) c).setUniversiryName(TextUtility.getNonEmptyString("Enter your university name: "));
    }

    public Candidate inputCandidateInformation() {
        switch (c.getType()) {
            case Experience:
                inputExperienceInformation();
                break;
            case Fresher:
                inputFresherInformation();
                break;
            case Intern:
                inputInternInformation();
                break;
        }
        return c;
    }
}
