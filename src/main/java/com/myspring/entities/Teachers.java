package com.myspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lname")
    private String lname;

    @Column(name = "fname")
    private String fname;

    @Column(name = "degree")
    private String degree;

    public Teachers() {
    }

    public Teachers(Long id) {
        this.id = id;
    }

    public Teachers(String lname, String fname, String degree) {
        this.lname = lname;
        this.fname = fname;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
