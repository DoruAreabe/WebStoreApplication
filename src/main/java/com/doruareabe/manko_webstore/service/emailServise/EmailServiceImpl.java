package com.doruareabe.manko_webstore.service.emailServise;

import com.doruareabe.manko_webstore.POJO.EmailPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendSimpleMessage(String to, EmailPojo emailPojo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(emailPojo.getSubject());
        message.setText(emailPojo.getMessage());
        emailSender.send(message);
    }
}
