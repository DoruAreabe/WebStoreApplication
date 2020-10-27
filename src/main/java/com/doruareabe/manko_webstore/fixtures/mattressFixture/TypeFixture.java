package com.doruareabe.manko_webstore.fixtures.mattressFixture;

import com.doruareabe.manko_webstore.entity.mattressEntity.Type;
import com.doruareabe.manko_webstore.service.mattressServise.TypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypeFixture {

    private final TypeServiceInterface typeService;

    @Autowired
    public TypeFixture(TypeServiceInterface typeService) {
        this.typeService = typeService;
    }
    
    public void feel(){
        Type t1 = new Type();
        Type t2 = new Type();
        
        t1.setTyp("Spreżynowy");
        t2.setTyp("Piankowy");
        
        typeService.save(t1);
        typeService.save(t2);
    }
}
