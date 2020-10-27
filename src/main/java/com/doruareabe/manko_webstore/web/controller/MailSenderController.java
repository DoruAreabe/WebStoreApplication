package com.doruareabe.manko_webstore.web.controller;

import com.doruareabe.manko_webstore.POJO.EmailPojo;
import com.doruareabe.manko_webstore.entity.EmailDB;
import com.doruareabe.manko_webstore.service.EmailDBServiceInterface;
import com.doruareabe.manko_webstore.service.emailServise.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class MailSenderController {

    public final EmailService emailService;
    public final EmailDBServiceInterface emailDBService;

    public MailSenderController(EmailService emailService, EmailDBServiceInterface emailDBService) {
        this.emailService = emailService;
        this.emailDBService = emailDBService;
    }

    @GetMapping("/sendmail")
    String sendMailForm(Model model) {
        model.addAttribute("mail", new EmailPojo());
        return "AdminPart/views/mailsender/sendForm";
    }

    @PostMapping("/sendmail")
    String sendMail(Model model, EmailPojo emailPojo) {
        List<EmailDB> emails = emailDBService.findAll();
        emails.stream().forEach(x -> emailService.sendSimpleMessage(x.getEmail(),emailPojo));
        return "AdminPart/views/mailsender/success";
    }
}
