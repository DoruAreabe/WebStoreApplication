package com.doruareabe.manko_webstore.fixtures;

import com.doruareabe.manko_webstore.entity.EmailDB;
import com.doruareabe.manko_webstore.service.EmailDBServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailDBFixture {

    EmailDBServiceInterface emailDBService;

    @Autowired
    public EmailDBFixture(EmailDBServiceInterface emailDBService) {
        this.emailDBService = emailDBService;
    }

    public void feel(){
        EmailDB email1 = new EmailDB();
        email1.setEmail("nik_ponomar@mail.ru");
        email1.setName("exampleName");
        emailDBService.save(email1);
        EmailDB email2 = new EmailDB();
        email2.setEmail("neket_ponomar@mail.ru");
        email2.setName("exampleName");
        emailDBService.save(email2);
    }
}
