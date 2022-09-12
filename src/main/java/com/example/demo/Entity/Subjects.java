package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "monhoc")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaMH")
    private String maMH;
    @Column(name = "maNganh")
    private String tenNganh;
    @Column(name = "TenMH")
    private String tenMH;
    @Column(name = "DVHT")
    private String dvht;

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getDvht() {
        return dvht;
    }

    public void setDvht(String dvht) {
        this.dvht = dvht;
    }
}
