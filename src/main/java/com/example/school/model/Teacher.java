package com.example.school.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable=false)
    private String firstName;

    @Column(name = "last_name", nullable=false)
    private String lastName;

    private String department;

    @Column(name = "years_experience")
    private Integer yearsExperience;

    public Teacher() {}

    public Teacher(String firstName, String lastName, String department, Integer yearsExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.yearsExperience = yearsExperience;
    }

    // getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Integer getYearsExperience() { return yearsExperience; }
    public void setYearsExperience(Integer yearsExperience) { this.yearsExperience = yearsExperience; }
}
