package com.doruareabe.manko_webstore.fixtures;

import com.doruareabe.manko_webstore.entity.ToContact;
import com.doruareabe.manko_webstore.service.ToContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToContactFixture {

    private final ToContactServiceInterface toContactService;

    @Autowired
    public ToContactFixture(ToContactServiceInterface toContactService) {
        this.toContactService = toContactService;
    }

     public void feel(){
         for (int i = 0; i < 10; i++) {
             ToContact toContact1 = new ToContact();
             toContact1.setName("marek");
             toContact1.setEmail("example@mail.com");
             toContact1.setPhone("333333333");
             toContact1.setMessage("SomeMessage");
             toContactService.save(toContact1);
         }
     }
}
