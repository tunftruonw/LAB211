/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.sound.sampled.SourceDataLine;

import utils.TextUtility;

/**
 *
 * @author tungs
 */
public class Experience extends Candidate {

    private int expInYear;
    private String proSkill;

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) throws Exception {
        int maxExpInYear = LocalDateTime.now().getYear() - super.getBirthDate();
        if (expInYear < 0 || expInYear > 100) {
            throw new Exception("Year of experience must >=0 and <=100");
        }
        if (expInYear > maxExpInYear) {
            throw new Exception("Year of experience can not greater your age");
        }
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = TextUtility.removeUnnecessaryBlank(proSkill);
    }
}
