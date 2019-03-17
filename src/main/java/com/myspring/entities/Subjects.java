package com.myspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "credits")
    private int credits;

    public Subjects() {
    }

    public Subjects(Long id) {
        this.id  = id;
    }

    public Subjects(String subjectName, int credits) {
        this.subjectName = subjectName;
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
