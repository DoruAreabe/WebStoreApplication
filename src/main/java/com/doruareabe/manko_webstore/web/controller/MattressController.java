package com.doruareabe.manko_webstore.web.controller;

import com.doruareabe.manko_webstore.entity.mattressEntity.*;
import com.doruareabe.manko_webstore.service.mattressServise.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class MattressController {
    private final MattressServiceInterface mattressService;
    private final CoverServiceInterface coverService;
    private final TypeServiceInterface typeService;
    private final DensityServiceInterface densityService;
    private final DimensionServiceInterface dimensionService;
    private final ExtraComponentServiceInterface extraComponentService;

    @Autowired
    public MattressController(MattressServiceInterface mattressService, CoverServiceInterface coverService, TypeServiceInterface typeService, DensityServiceInterface densityService, DimensionServiceInterface dimensionService, ExtraComponentServiceInterface extraComponentService) {
        this.mattressService = mattressService;
        this.coverService = coverService;
        this.typeService = typeService;
        this.densityService = densityService;
        this.dimensionService = dimensionService;
        this.extraComponentService = extraComponentService;
    }


    @GetMapping("/mattress")
    String getMainPage(Model model) {
        List<Mattress> mattresses = mattressService.findAll();
        model.addAttribute("mattresses", mattresses);
        return "AdminPart/views/mattress/mattress";
    }

    @GetMapping("mattress/details/{id}")
    public String mattressDetails(@PathVariable Long id, Model model) {
        Mattress mattress = mattressService.findOneByIdWithAllFields(id);
        model.addAttribute("mattress", mattress);
        return "AdminPart/views/mattress/details";
    }
    @GetMapping("mattress/edit/{id}")
    public String mattressEdit(@PathVariable Long id, Model model) {
        Mattress mattress = mattressService.findOneByIdWithAllFields(id);
        model.addAttribute("mattressObject", mattress);
        return "AdminPart/views/mattress/edit";
    }
    @PostMapping("mattress/edit")
    public String mattressEdit(@RequestParam("File_img") MultipartFile img, @ModelAttribute("mattressObject") @Validated Mattress mattress, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/mattress/edit";
        }
        Mattress mattressFromDB = mattressService.findOneByIdWithAllFields(mattress.getId());
        mattress.setImg(mattressFromDB.getImg());
        Mattress mattressWrited = mattressService.save(mattress);
        if(!img.isEmpty()){
            Path path = Paths.get("target/classes/static/img/"+mattressWrited.getId()+".png");
            try {
                byte[] bytes = img.getBytes();
                Files.write(path,bytes);
                mattressWrited.setImg(mattressWrited.getId()+".png");
                mattressService.save(mattressWrited);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/mattress";
    }

    @PostMapping("mattress/add")
    public String mattressAdd(@RequestParam("File_img") MultipartFile img, @Validated Mattress mattress, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            if(img.isEmpty()) model.addAttribute("message", true);
            return "AdminPart/views/mattress/add";
        }
        if(img.isEmpty()){
            model.addAttribute("message", true);
            return "AdminPart/views/mattress/add";
        }
        Mattress mattressWrited = mattressService.save(mattress);
        Path path = Paths.get("target/classes/static/img/"+mattressWrited.getId()+".png");
        try {
            byte[] bytes = img.getBytes();
            Files.write(path,bytes);
            mattressWrited.setImg(mattressWrited.getId()+".png");
            mattressService.save(mattressWrited);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/mattress";
    }

    @ModelAttribute
    public void components(Model model){
        List<Cover> covers = coverService.findAll();
        List<Type> types = typeService.findAll();
        List<Density> densities = densityService.findAll();
        List<Dimension> dimensions = dimensionService.findAll();
        List<ExtraComponent> extraComponents = extraComponentService.findAll();
        model.addAttribute("covers", covers);
        model.addAttribute("types", types);
        model.addAttribute("densities", densities);
        model.addAttribute("dimensions", dimensions);
        model.addAttribute("extraComponents", extraComponents);
    }

    @GetMapping("mattress/add")
    public String mattressAddForm(Model model) {
        Mattress mattress = new Mattress();
        model.addAttribute("mattress", mattress);
        return "AdminPart/views/mattress/add";
    }

    @GetMapping("mattress/delete/{id}")
    public String mattressDelete(@PathVariable Long id) {
        mattressService.deleteById(id);
        return "redirect:/admin/mattress";
    }

    @GetMapping("mattress/changeavailability/{id}")
    public String mattressChangeAvailability(@PathVariable Long id) {
        Mattress mattress = mattressService.findById(id);
        mattress.setAvailability(!mattress.getAvailability());
        mattressService.save(mattress);
        return "redirect:/admin/mattress";
    }


}
