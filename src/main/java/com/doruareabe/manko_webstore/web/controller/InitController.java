package com.doruareabe.manko_webstore.web.controller;

import com.doruareabe.manko_webstore.fixtures.FixtureFasade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitController {
    private final FixtureFasade fixtureFasade;

    @Autowired
    public InitController(FixtureFasade fixtureFasade) {
        this.fixtureFasade = fixtureFasade;
    }

    @GetMapping("/initMattress")
    @ResponseBody
    String initMattress(){
        fixtureFasade.feel();
        return "Ok";
    }
}
