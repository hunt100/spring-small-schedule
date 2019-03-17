package com.myspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "class_type")
public class ClassType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "class_type")
    private String classType;

    public ClassType() {
    }

    public ClassType(Long id) {
        this.id = id;
    }

    public ClassType(String classType) {
        this.classType = classType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
