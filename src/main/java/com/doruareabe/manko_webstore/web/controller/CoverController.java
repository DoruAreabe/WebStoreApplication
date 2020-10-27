package com.doruareabe.manko_webstore.web.controller;

import com.doruareabe.manko_webstore.entity.mattressEntity.Cover;
import com.doruareabe.manko_webstore.service.mattressServise.CoverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CoverController {

    private final CoverServiceInterface coverService;

    @Autowired
    public CoverController(CoverServiceInterface coverService) {
        this.coverService = coverService;
    }

    @GetMapping("/cover")
    public String showCover(Model model) {
        List<Cover> covers = coverService.findAll();
        model.addAttribute("covers", covers);
        return "AdminPart/views/covers/cover";
    }

    @PostMapping("/cover/add")
    public String addCoverAction(@Valid Cover cover, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/covers/add";
        }
        coverService.save(cover);
        return "redirect:/admin/cover";
    }
    @PostMapping("/cover/edit")
    public String editCoverAction(@Valid Cover cover, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "AdminPart/views/covers/edit";
        }
        coverService.save(cover);
        return "redirect:/admin/cover";
    }

    @GetMapping("/cover/add")
    public String addCoverForm(Model model) {
        Cover cover = new Cover();
        model.addAttribute("cover", cover);
        return "AdminPart/views/covers/add";
    }

    @GetMapping("/cover/edit/{id}")
    public String editCoverForm(Model model, @PathVariable Long id) {
        Cover cover = coverService.findById(id);
        model.addAttribute("cover", cover);
        return "AdminPart/views/covers/edit";
    }

    @PostMapping("/cover/{id}")
    public String deleteCover(@PathVariable Long id) {
        try {
            coverService.deleteById(id);
            return "redirect:/admin/cover";
        } catch (Exception e) {
            return "AdminPart/views/covers/error";
        }


    }

}