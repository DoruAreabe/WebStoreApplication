package com.doruareabe.manko_webstore.web.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class ImagesController {

    @GetMapping(
            value = "/image/{id}.png",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public @ResponseBody
    byte[] getImageWithMediaType(@PathVariable int id) throws IOException {
        Path path = Paths.get("target/classes/static/img/" + id + ".png");
        byte[] result = Files.readAllBytes(path);
        return result;
    }

}
