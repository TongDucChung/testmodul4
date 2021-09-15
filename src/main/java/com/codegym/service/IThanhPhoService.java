package com.codegym.service;

import com.codegym.models.ThanhPho;

import java.util.List;

public interface IThanhPhoService {
    List<ThanhPho> findAll();

    ThanhPho findById(long id);

    ThanhPho saveNV(ThanhPho thanhPho);

    void deleteNV(ThanhPho thanhPho);
}
