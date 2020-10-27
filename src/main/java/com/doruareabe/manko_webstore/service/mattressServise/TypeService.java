package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.Type;
import com.doruareabe.manko_webstore.repository.mattress.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements TypeServiceInterface {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type findById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type save(Type variable) {
        return typeRepository.save(variable);
    }
}
