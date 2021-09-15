package com.codegym.service;

import com.codegym.models.DatNuoc;
import com.codegym.repository.IDatNuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatNuocService implements IDatNuocSerVice {
    @Autowired
    IDatNuocRepository iDatNuocRepository;

    @Override
    public List<DatNuoc> findAll() {
        return (List<DatNuoc>) iDatNuocRepository.findAll();
    }
}
