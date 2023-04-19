/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import bo.CandidateManager;
import controller.CandidateManagerController;
import utils.TextUtility;

/**
 *
 * @author tungs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CandidateManagerController candidateManagerController = new CandidateManagerController();
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        String menu
                = "1.Experience\n"
                + "2.Fresher\n"
                + "3.Interrlship\n"
                + "4.Searching\n"
                + "5.Exit\n\n"
                + "(Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program).\n"
                + "Your choice: ";
        while (true) {
            int choice = TextUtility.getInt(menu, "You must input an integer number", "Must in range of 1-5", 1, 5);
            switch (choice) {
                case 1:
                    candidateManagerController.addCandidateByOptionMenu(choice);
                    break;
                case 2:
                    candidateManagerController.addCandidateByOptionMenu(choice);
                    break;
                case 3:
                    candidateManagerController.addCandidateByOptionMenu(choice);
                    break;
                case 4:
                    candidateManagerController.searchCandidateByName();
                    break;
                case 5:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
