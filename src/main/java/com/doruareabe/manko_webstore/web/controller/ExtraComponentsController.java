package com.doruareabe.manko_webstore.web.controller;


import com.doruareabe.manko_webstore.entity.mattressEntity.ExtraComponent;
import com.doruareabe.manko_webstore.service.mattressServise.ExtraComponentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ExtraComponentsController {

    private final ExtraComponentServiceInterface extraComponentService;

    @Autowired
    public ExtraComponentsController(ExtraComponentServiceInterface extraComponentService) {
        this.extraComponentService = extraComponentService;
    }


    @GetMapping("/extraComponent")
    public String showExtraComponent(Model model) {
        List<ExtraComponent> extraComponents = extraComponentService.findAll();
        model.addAttribute("extraComponents", extraComponents);
        return "AdminPart/views/extraComponents/extraComponents";
    }

    @PostMapping("/extraComponent/add")
    public String addExtraComponentAction(@ModelAttribute("extraComponentObject") @Valid ExtraComponent extraComponent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/extraComponents/add";
        }
        extraComponentService.save(extraComponent);
        return "redirect:/admin/extraComponent";
    }

    @PostMapping("/extraComponent/edit")
    public String editExtraComponentsAction(@ModelAttribute("extraComponentObject") @Valid ExtraComponent extraComponent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/extraComponents/edit";
        }
        extraComponentService.save(extraComponent);
        return "redirect:/admin/extraComponent";
    }


    @GetMapping("/extraComponent/edit/{id}")
    public String editExtraComponentForm(Model model, @PathVariable Long id) {
        ExtraComponent extraComponent = extraComponentService.findById(id);
        model.addAttribute("extraComponentObject", extraComponent);
        return "AdminPart/views/extraComponents/edit";
    }


    @GetMapping("/extraComponent/add")
    public String addExtraComponentForm(Model model) {
        ExtraComponent extraComponent = new ExtraComponent();
        model.addAttribute("extraComponentObject", extraComponent);
        return "AdminPart/views/extraComponents/add";
    }

    @PostMapping("/extraComponent/{id}")
    public String deleteExtraComponent(@PathVariable Long id) {
        try {
            extraComponentService.deleteById(id);
            return "redirect:/admin/extraComponent";
        } catch (Exception e) {
            return "AdminPart/views/extraComponents/error";
        }


    }

}
