package com.pg.scripts.n1qlgenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pg.scripts.n1qlgenerator.service.GeneratorService;

@RestController
@RequestMapping("/generate/scripts")
public class GeneratorController {

    private final GeneratorService service;

    public GeneratorController(GeneratorService service) {
        this.service = service;
    }

    @GetMapping
    public String generateScripts(){
        service.generateFile();
        return "zrobione";
    }


}
