package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.ExtraComponent;
import com.doruareabe.manko_webstore.repository.mattress.ExtraComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraComponentService implements ExtraComponentServiceInterface {

    private final ExtraComponentRepository extraComponentRepository;

    @Autowired
    public ExtraComponentService(ExtraComponentRepository extraComponentRepository) {
        this.extraComponentRepository = extraComponentRepository;
    }

    @Override
    public ExtraComponent findById(Long id) {
        return extraComponentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        extraComponentRepository.deleteById(id);
    }

    @Override
    public List<ExtraComponent> findAll() {
        return extraComponentRepository.findAll();
    }

    @Override
    public ExtraComponent save(ExtraComponent variable) {
        return extraComponentRepository.save(variable);
    }
}
