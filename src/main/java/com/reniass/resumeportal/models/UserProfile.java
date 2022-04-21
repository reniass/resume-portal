package com.reniass.resumeportal.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int theme;
    @Column
    private String summary;
    private String designation;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    orphanRemoval = true)
    @JoinColumn(name = "user_profile_id")
    private List<Job> jobs = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_profile_id")
    private List<Education> educations = new ArrayList<>();

    @ElementCollection(targetClass = String.class)
    private List<String> skills = new ArrayList<>();

    public UserProfile() {}

    public UserProfile(String username, String firstName, String lastName,
                       String phone, String email, int theme, String summary,
                       String designation, List<Job> jobs,
                       List<String> skills, List<Education> educations) {
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.theme = theme;
        this.summary = summary;
        this.designation = designation;
        this.jobs = jobs;
        this.skills = skills;
        this.educations = educations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }
}
