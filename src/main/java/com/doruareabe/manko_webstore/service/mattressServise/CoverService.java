package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.Cover;
import com.doruareabe.manko_webstore.repository.mattress.CoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverService implements CoverServiceInterface {

    private final CoverRepository coverRepository;

    @Autowired
    public CoverService(CoverRepository coverRepository) {
        this.coverRepository = coverRepository;
    }

    @Override
    public Cover findById(Long id) {
        return coverRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        coverRepository.deleteById(id);
    }

    @Override
    public List<Cover> findAll() {
        return coverRepository.findAll();
    }

    @Override
    public Cover save(Cover variable) {
        Cover exist = findCoverByCover(variable.getCovr());
        if(exist!=null) return null;
        return coverRepository.save(variable);
    }

    @Override
    public Cover findCoverByCover(String cover) {
        return coverRepository.findCoverByCovr(cover);
    }
}
