package com.doruareabe.manko_webstore.web.controller;

import com.doruareabe.manko_webstore.entity.ToContact;
import com.doruareabe.manko_webstore.service.ToContactServiceInterface;
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
public class ToContactController {

    ToContactServiceInterface toContactService;

    @Autowired
    public ToContactController(ToContactServiceInterface toContactService) {
        this.toContactService = toContactService;
    }

    @GetMapping("/tocontact")
    public String showToContact(Model model) {
        List<ToContact> toContact = toContactService.findAll();
        model.addAttribute("toContacts", toContact);
        return "AdminPart/views/toContact/toContact";
    }

    @PostMapping("/tocontact/{id}")
    public String deleteToContact(@PathVariable Long id) {
        toContactService.deleteById(id);
        return "redirect:/admin/tocontact";
    }

    @GetMapping("/tocontact/details/{id}")
    public String addDimensionAction(@PathVariable Long id,Model model) {
        ToContact toContact = toContactService.findById(id);
        model.addAttribute("toContact",toContact);
        return "AdminPart/views/toContact/details";
    }
}