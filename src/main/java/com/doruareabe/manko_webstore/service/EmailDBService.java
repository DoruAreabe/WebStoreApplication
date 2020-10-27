package com.doruareabe.manko_webstore.service;

import com.doruareabe.manko_webstore.entity.EmailDB;
import com.doruareabe.manko_webstore.repository.EmailDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailDBService implements EmailDBServiceInterface {

    private final EmailDBRepository emailDBRepository;

    @Autowired
    public EmailDBService(EmailDBRepository emailDBRepository) {
        this.emailDBRepository = emailDBRepository;
    }

    @Override
    public EmailDB findById(Long id) {
        return emailDBRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        emailDBRepository.deleteById(id);
    }

    @Override
    public List<EmailDB> findAll() {
        return emailDBRepository.findAll();
    }

    @Override
    public EmailDB save(EmailDB variable) {
        return emailDBRepository.save(variable);
    }
}
