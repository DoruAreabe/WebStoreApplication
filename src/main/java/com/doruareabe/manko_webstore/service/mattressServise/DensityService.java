package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.Density;
import com.doruareabe.manko_webstore.repository.mattress.DensityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DensityService implements DensityServiceInterface {

    private final DensityRepository densityRepository;

    @Autowired
    public DensityService(DensityRepository densityRepository) {
        this.densityRepository = densityRepository;
    }

    @Override
    public Density findById(Long id) {
        return densityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        densityRepository.deleteById(id);
    }

    @Override
    public List<Density> findAll() {
        return densityRepository.findAll();
    }

    @Override
    public Density save(Density variable) {
        Density exist = findDensityByDensity(variable.getDensit());
        if(exist!=null) return null;
        return densityRepository.save(variable);
    }

    @Override
    public Density findDensityByDensity(String density) {
        return densityRepository.findDensityByDensit(density);
    }
}
