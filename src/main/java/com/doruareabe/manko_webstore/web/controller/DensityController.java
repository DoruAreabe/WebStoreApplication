package com.doruareabe.manko_webstore.web.controller;

import com.doruareabe.manko_webstore.entity.mattressEntity.Density;
import com.doruareabe.manko_webstore.service.mattressServise.DensityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class DensityController {

    private final DensityServiceInterface densityService;

    @Autowired
    public DensityController(DensityServiceInterface densityService) {
        this.densityService = densityService;
    }


    @GetMapping("/density")
    public String showDensity(Model model) {
        List<Density> densities = densityService.findAll();
        model.addAttribute("densities", densities);
        return "AdminPart/views/densities/density";
    }

    @PostMapping("/density/add")
    public String addDensityAction(@Valid Density density, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/densities/add";
        }
        densityService.save(density);
        return "redirect:/admin/density";
    }
    @PostMapping("/density/edit")
    public String editDensityAction(@Valid Density density, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/densities/edit";
        }
        densityService.save(density);
        return "redirect:/admin/density";
    }

    @GetMapping("/density/add")
    public String addDensityForm(Model model) {
        Density density = new Density();
        model.addAttribute("density", density);
        return "AdminPart/views/densities/add";
    }

    @GetMapping("/density/edit/{id}")
    public String editDensityForm(Model model, @PathVariable Long id) {
        Density density = densityService.findById(id);
        model.addAttribute("density", density);
        return "AdminPart/views/densities/edit";
    }

    @PostMapping("/density/{id}")
    public String deleteDensity(@PathVariable Long id) {
        try {
            densityService.deleteById(id);
            return "redirect:/admin/density";
        } catch (Exception e) {
            return "AdminPart/views/densities/error";
        }


    }

}
