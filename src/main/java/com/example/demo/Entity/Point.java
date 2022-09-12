package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "ppoint")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "class")
    private String lop;
    @Column(name = "MaMH")
    private String tenMH;
    @Column(name = "HocKy")
    private String hocky;
    @Column(name = "diemCC")
    private String diemCC;
    @Column(name = "diemGK")
    private String diemGK;
    @Column(name = "diemKTHP")
    private String diemKTHP;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getHocky() {
        return hocky;
    }

    public void setHocky(String hocky) {
        this.hocky = hocky;
    }

    public String getDiemCC() {
        return diemCC;
    }

    public void setDiemCC(String diemCC) {
        this.diemCC = diemCC;
    }

    public String getDiemGK() {
        return diemGK;
    }

    public void setDiemGK(String diemGK) {
        this.diemGK = diemGK;
    }

    public String getDiemKTHP() {
        return diemKTHP;
    }

    public void setDiemKTHP(String diemKTHP) {
        this.diemKTHP = diemKTHP;
    }
}
