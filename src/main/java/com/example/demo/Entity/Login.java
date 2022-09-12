package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "loginn")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "passworld")
    private String passworld;

    public String getId() {
        return id;
    }

    public void setId(String maMH) {
        this.id = id;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }
}
