package com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
@Entity
@Table(name = "JobRole")
public class JobRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="jobRole_id")
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Column(name = "title", nullable = false)
    private String title;
    private String description;
    private String qualification;

    public JobRole(Long id, String title, String description,
                   String qualification, Integer experience, Date postedDate, Double salary) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.qualification = qualification;
        this.experience = experience;
        this.postedDate = postedDate;
        this.salary = salary;
    }

    @Column(name="experience")
    private Integer experience;

    @Column(name="postedDate")
    private Date postedDate;

    @Column(name="salary")
    private Double salary;




}
