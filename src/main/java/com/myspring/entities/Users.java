package com.myspring.entities;

//import sun.jvm.hotspot.gc.shared.Generation;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name="password")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade( value = org.hibernate.annotations.CascadeType.ALL)
    private Set<Roles> roles;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Groups group;

    public Users(){

    };

    public Users(String email, String password, Set<Roles> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        group = null;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Roles> getRoles() {
        return roles;
    }
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

}
