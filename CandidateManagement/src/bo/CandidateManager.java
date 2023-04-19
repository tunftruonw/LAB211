/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import models.Candidate;

/**
 *
 * @author tungs
 */
public class CandidateManager {

    private ArrayList<Candidate> candidates;
    //Create a array list for contain Candidates
    private int lastId;

    public CandidateManager() {
        candidates = new ArrayList<>();
        lastId = 0;
    }

    public CandidateManager(ArrayList<Candidate> temp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //add new candidate
    public Candidate addCandidate(Candidate c) {
        c.setId(++lastId);
        //automatic ascending id for each new candidate
        candidates.add(c);
        return c;
    }

    //find id from iputed id
    public int searchById(int id) {
        for (int index = 0; index < candidates.size(); index++) {
            if (candidates.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    //update candidate 
    public Candidate updateCandidate(int id, Candidate c) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return candidates.set(index, c);
            //update candidate by index 
        }
        throw new Exception("Candidate not found!");
    }

    public Candidate deleteCandidate(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return candidates.remove(index);
            //remove candidate by index
        }
        throw new Exception("Does not exist");
    }

    public Candidate getCandidateById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return candidates.get(index);
            //get candidate by index
        }
        throw new Exception("ID not found!");
    }

    public ArrayList<Candidate> searchByNameAndType(String name, Candidate.CandidateType type) {
        ArrayList<Candidate> search = new ArrayList<>();
        for (Candidate c : candidates) {
            if (c.getType() == type && c.getFirstName().equalsIgnoreCase(name) || c.getLastName().equalsIgnoreCase(name)) {
                search.add(c);
            }
        }
        return search;
    }

    @Override
    public String toString() {
        String experience = "\n===========EXPERIENCE CANDIDATE============\n";
        String fresher = "\n===========FRESHER CANDIDATE===============\n";
        String intern = "\n===========INTERN CANDIDATE================\n";
        for (Candidate c : candidates) {
            switch (c.getType()) {
                case Experience:
                    experience += c.getFirstName() + " " + c.getLastName() + "\n";
                    break;
                case Fresher:
                    fresher += c.getFirstName() + " " + c.getLastName() + "\n";
                    break;
                case Intern:
                    intern += c.getFirstName() + " " + c.getLastName() + "\n";
                    break;
                default:
                    throw new AssertionError();
            }
        }

        return experience + fresher + intern;
    }

}
