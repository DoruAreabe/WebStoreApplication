package com.doruareabe.manko_webstore.service;

import com.doruareabe.manko_webstore.entity.ToContact;
import com.doruareabe.manko_webstore.repository.ToContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToContactService implements ToContactServiceInterface {

    private final ToContactRepository toContactRepository;

    @Autowired
    public ToContactService(ToContactRepository toContactRepository) {
        this.toContactRepository = toContactRepository;
    }

    @Override
    public ToContact findById(Long id) {
        return toContactRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        toContactRepository.deleteById(id);
    }

    @Override
    public List<ToContact> findAll() {
        return toContactRepository.findAll();
    }

    @Override
    public ToContact save(ToContact variable) {
        return toContactRepository.save(variable);
    }
}
