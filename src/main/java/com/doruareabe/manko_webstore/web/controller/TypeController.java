package com.doruareabe.manko_webstore.web.controller;

import com.doruareabe.manko_webstore.entity.mattressEntity.Type;
import com.doruareabe.manko_webstore.service.mattressServise.TypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {

    private final TypeServiceInterface typeService;

    @Autowired
    public TypeController(TypeServiceInterface typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/type")
    public String showType(Model model) {
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
        return "AdminPart/views/types/type";
    }

    @PostMapping("/type/add")
    public String addTypeAction(@Valid Type type, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/types/add";
        }
        typeService.save(type);
        return "redirect:/admin/type";
    }
    @PostMapping("/type/edit")
    public String editTypeAction(@Valid Type type, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/types/edit";
        }
        typeService.save(type);
        return "redirect:/admin/type";
    }
    @GetMapping("/type/add")
    public String addTypeForm(Model model) {
        Type type = new Type();
        model.addAttribute("type", type);
        return "AdminPart/views/types/add";
    }
    @GetMapping("/type/edit/{id}")
    public String editTypeForm(Model model,@PathVariable Long id) {
        Type type = typeService.findById(id);
        model.addAttribute("type", type);
        return "AdminPart/views/types/edit";
    }

    @PostMapping("/type/{id}")
    public String deleteType(@PathVariable Long id) {
        try {
            typeService.deleteById(id);
            return "redirect:/admin/type";
        } catch (Exception e) {
            return "AdminPart/views/types/error";
        }

    }

}
