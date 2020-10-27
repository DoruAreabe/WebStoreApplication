package com.doruareabe.manko_webstore.web.controller;

import com.doruareabe.manko_webstore.entity.EmailDB;
import com.doruareabe.manko_webstore.service.EmailDBServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EmailDBController {

    private final EmailDBServiceInterface emailDBService;

    @Autowired
    public EmailDBController(EmailDBServiceInterface emailDBService) {
        this.emailDBService = emailDBService;
    }


    @GetMapping("/clients")
    public String showMailsDB(Model model) {
        List<EmailDB> emails = emailDBService.findAll();
        model.addAttribute("emails", emails);
        return "AdminPart/views/clients/clients";
    }

    @PostMapping("/clients/{id}")
    public String deleteClientData(@PathVariable Long id) {
        emailDBService.deleteById(id);
        return "redirect:/admin/clients";
    }
}