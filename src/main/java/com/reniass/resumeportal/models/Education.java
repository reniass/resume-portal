package com.reniass.resumeportal.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String college;
    private String qualification;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String summary;

    public Education() {}

    public Education(String college, String qualification,
                     LocalDate startDate, LocalDate endDate,
                     String summary) {
        this.college = college;
        this.qualification = qualification;
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFormattedStartDate() {
        return startDate.format(DateTimeFormatter.ofPattern("MMM uuuu", Locale.ENGLISH));
    }

    public String getFormattedEndDate() {
        return startDate.format(DateTimeFormatter.ofPattern("MMM uuuu", Locale.ENGLISH));
    }
}
