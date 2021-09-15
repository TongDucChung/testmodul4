package com.codegym.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(min = 3, max = 30, message = "Nhap qua ngan,hoac qua dai")
    private String tenTP;

    @Column(nullable = false)
    @Min(value = 0, message = "Nhap vao so nguyen")
    private int dienTich;

    @Column(nullable = false)
    @Min(value = 0, message = "Nhap vao so nguyen")
    private int danSo;

    @Column(nullable = false)
    @Min(value = 0, message = "Nhap vao so nguyen")
    private int gdp;

    private String moTa;

    @ManyToOne
    private DatNuoc datNuoc;

    public ThanhPho() {
    }

    public ThanhPho(long id, String tenTP, int dienTich, int danSo, int gdp, String moTa, DatNuoc datNuoc) {
        this.id = id;
        this.tenTP = tenTP;
        this.dienTich = dienTich;
        this.danSo = danSo;
        this.gdp = gdp;
        this.moTa = moTa;
        this.datNuoc = datNuoc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getDanSo() {
        return danSo;
    }

    public void setDanSo(int danSo) {
        this.danSo = danSo;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public DatNuoc getDatNuoc() {
        return datNuoc;
    }

    public void setDatNuoc(DatNuoc datNuoc) {
        this.datNuoc = datNuoc;
    }
}
