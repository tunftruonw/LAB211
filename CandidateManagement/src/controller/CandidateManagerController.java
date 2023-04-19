/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.CandidateInputer;
import bo.CandidateManager;
import java.util.ArrayList;
import models.Candidate;
import models.Experience;
import models.Fresher;
import models.Intern;
import utils.TextUtility;

/**
 *
 * @author tungs
 */
public class CandidateManagerController {

    private CandidateInputer candidateInputer;
    private CandidateManager candidateManager;

    public CandidateManagerController() {
        candidateManager = new CandidateManager();
    }

    private Candidate inputCandidate(Candidate.CandidateType type) {
        candidateInputer = new CandidateInputer(type);
        candidateInputer.inputCandidateInformation();
        Candidate c = candidateInputer.getC();
        candidateManager.addCandidate(c);
        return c;
    }

    private Experience addExperienceCandidate() {
        Experience c = (Experience) inputCandidate(Candidate.CandidateType.Experience);
        return c;
    }

    private Fresher addFresherCandidate() {
        Fresher c = (Fresher) inputCandidate(Candidate.CandidateType.Fresher);
        return c;
    }

    private Intern addInternCandidate() {
        Intern c = (Intern) inputCandidate(Candidate.CandidateType.Intern);
        return c;
    }

    public void addCandidateByOptionMenu(int choice) {
        ArrayList<Candidate> temp = new ArrayList<>();
        do {
            switch (choice) {
                case 1:
                    temp.add(addExperienceCandidate());
                    break;
                case 2:
                    temp.add(addFresherCandidate());
                    break;
                case 3:
                    temp.add(addInternCandidate());
                    break;
            }
        } while (TextUtility.pressYNtoContinue("Do you want to continue Y/N"));
        System.out.println("List of candidate");
//        for (Candidate c : temp) {
//            System.out.println(c.getFullName());
//        }
        displayAllCandidate();
    }

    private void displayAllCandidate() {
        System.out.println(candidateManager);
    }

    public void searchCandidateByName() {
        displayAllCandidate();
        String name = TextUtility.getNonEmptyString("Input andidate name (First name or Last name) :");
        int type = TextUtility.getInt("Input type of candidate (0: Experience, 1: Fresher, 2: Intern): ", "Please enter an integer number", "Integer number must in range 0-2", 0, 2);
        ArrayList<Candidate> listFound = candidateManager.searchByNameAndType(name, Candidate.CandidateType.getTypeByInt(type));
        if (listFound.isEmpty()){
            System.out.println("\nNo candidate found\n");
        } else {
            System.out.println("\nFound List:");
            for (Candidate c : listFound) {
                System.out.println(c);
            }
        }
    }

}
