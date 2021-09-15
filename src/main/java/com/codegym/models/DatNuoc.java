package com.codegym.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DatNuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tenDn;


    public DatNuoc() {
    }

    public DatNuoc(long id, String tenDn) {
        this.id = id;
        this.tenDn = tenDn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenDn() {
        return tenDn;
    }

    public void setTenDn(String tenDn) {
        this.tenDn = tenDn;
    }
}
