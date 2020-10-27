package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.Mattress;
import com.doruareabe.manko_webstore.repository.mattress.MattressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MattressService implements MattressServiceInterface {

    private final MattressRepository mattressRepository;

    @Autowired
    public MattressService(MattressRepository mattressRepository) {
        this.mattressRepository = mattressRepository;
    }


    @Override
    public Mattress findById(Long id) {
        return mattressRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        mattressRepository.deleteById(id);
    }

    @Override
    public List<Mattress> findAll() {
        return mattressRepository.findAll();
    }

    @Override
    public Mattress save(Mattress variable) {
        return mattressRepository.save(variable);
    }

    @Override
    public Mattress findOneByIdWithAllFields(Long id) {
        return mattressRepository.getMattressWithAllFieldsById(id);
    }
}
