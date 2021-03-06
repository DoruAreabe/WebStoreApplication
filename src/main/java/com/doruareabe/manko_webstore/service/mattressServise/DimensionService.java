package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.Dimension;
import com.doruareabe.manko_webstore.repository.mattress.DimensionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimensionService implements DimensionServiceInterface{

    private final DimensionsRepository dimensionsRepository;

    public DimensionService(DimensionsRepository dimensionsRepository) {
        this.dimensionsRepository = dimensionsRepository;
    }

    @Override
    public Dimension findById(Long id) {
        return dimensionsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        dimensionsRepository.deleteById(id);
    }

    @Override
    public List<Dimension> findAll() {
        return dimensionsRepository.findAll();
    }

    @Override
    public Dimension save(Dimension variable) {
        Dimension exist = findDimensionByDimension(variable.getDimension());
        if(exist!=null) return null;
        variable.setDimension(variable.getDimension().trim());
        return dimensionsRepository.save(variable);
    }

    @Override
    public Dimension findDimensionByDimension(String dimension) {
        return dimensionsRepository.findDimensionByDimension(dimension);
    }
}
