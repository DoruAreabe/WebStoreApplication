package com.doruareabe.manko_webstore.service.emailServise;

import com.doruareabe.manko_webstore.POJO.EmailPojo;

public interface EmailService {
    public void sendSimpleMessage(String to, EmailPojo emailPojo);
}
