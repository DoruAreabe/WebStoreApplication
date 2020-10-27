package com.doruareabe.manko_webstore.web.controller;

import com.doruareabe.manko_webstore.entity.mattressEntity.Dimension;
import com.doruareabe.manko_webstore.service.mattressServise.DimensionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class DimensionController {

    private final DimensionServiceInterface dimensionService;

    @Autowired
    public DimensionController(DimensionServiceInterface dimensionService) {
        this.dimensionService = dimensionService;
    }

    @GetMapping("/dimension")
    public String showDimension(Model model) {
        List<Dimension> dimensions = dimensionService.findAll();
        model.addAttribute("dimensions", dimensions);
        return "AdminPart/views/dimensions/dimension";
    }

    @PostMapping("/dimension/add")
    public String addDimensionAction(@ModelAttribute("dimensionObject") @Valid Dimension dimension, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/dimensions/add";
        }
        dimensionService.save(dimension);
        return "redirect:/admin/dimension";
    }
    @PostMapping("/dimension/edit")
    public String editDimensionAction(@ModelAttribute("dimensionObject") @Valid Dimension dimension, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/dimensions/edit";
        }
        dimensionService.save(dimension);
        return "redirect:/admin/dimension";
    }

    @GetMapping("/dimension/add")
    public String addDimensionForm(Model model) {
        Dimension dimension = new Dimension();
        model.addAttribute("dimensionObject", dimension);
        return "AdminPart/views/dimensions/add";
    }

    @GetMapping("/dimension/edit/{id}")
    public String editDimensionForm(Model model, @PathVariable Long id) {
        Dimension dimension = dimensionService.findById(id);
        model.addAttribute("dimensionObject", dimension);
        return "AdminPart/views/dimensions/edit";
    }

    @PostMapping("/dimension/{id}")
    public String deleteDimension(@PathVariable Long id) {
        try {
            dimensionService.deleteById(id);
            return "redirect:/admin/dimension";
        } catch (Exception e) {
            return "AdminPart/views/dimensions/error";
        }


    }

}