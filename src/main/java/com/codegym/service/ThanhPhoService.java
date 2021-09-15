package com.codegym.service;

import com.codegym.models.ThanhPho;
import com.codegym.repository.IThanhPhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThanhPhoService implements IThanhPhoService{
    @Autowired
    IThanhPhoRepository iThanhPhoRepository;
    @Override
    public List<ThanhPho> findAll() {
        return (List<ThanhPho>) iThanhPhoRepository.findAll();
    }

    @Override
    public ThanhPho findById(long id) {
        return iThanhPhoRepository.findById(id).get();
    }

    @Override
    public ThanhPho saveNV(ThanhPho thanhPho) {
        return iThanhPhoRepository.save(thanhPho);
    }

    @Override
    public void deleteNV(ThanhPho thanhPho) {
        iThanhPhoRepository.delete(thanhPho);
    }
}
