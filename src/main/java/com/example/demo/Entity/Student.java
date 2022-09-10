package com.example.demo.Entity;


import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "Hoten")
    private String Name;
    @Column(name = "Birthday")
    private LocalDate birthDay;
    @Column(name = "Gender")
    private String Gender;
    @Column(name = "Ethnic")
    private String Ethnic;
    @Column(name = "Email")
    private String email;
    @Column(name = "Cccd")
    private String cccd;
    @Column(name = "Addres")
    private String address;
    @Column(name = "Phone")
    private String phone;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEthnic() {
        return Ethnic;
    }

    public void setEthnic(String ethnic) {
        Ethnic = ethnic;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
