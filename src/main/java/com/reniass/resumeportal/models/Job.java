package com.reniass.resumeportal.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String company;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean currentJob;
    @ElementCollection(targetClass = String.class)
    private List<String> responsibilities = new ArrayList<>();

    public Job() {}

    public Job(String company, String designation, LocalDate startDate,
               LocalDate endDate, boolean currentJob, List<String> responsibilities) {
        this.company = company;
        this.designation = designation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentJob = false;
        this.responsibilities = responsibilities;
    }

    public Job(String company, String designation, LocalDate startDate,
               boolean currentJob, List<String> responsibilities) {
        this.company = company;
        this.designation = designation;
        this.startDate = startDate;
        this.currentJob = true;
        this.responsibilities = responsibilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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

    public boolean isCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(boolean currentJob) {
        this.currentJob = currentJob;
    }

    public String getFormattedStartDate() {
        return startDate.format(DateTimeFormatter.ofPattern("MMM uuuu", Locale.ENGLISH));
    }

    public String getFormattedEndDate() {
        return startDate.format(DateTimeFormatter.ofPattern("MMM uuuu", Locale.ENGLISH));
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", designation='" + designation + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
