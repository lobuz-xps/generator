package com.pg.scripts.n1qlgenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pg.scripts.n1qlgenerator.service.GeneratorService;

@RestController
@RequestMapping("/api")
public class GeneratorController {

    private final GeneratorService service;

    public GeneratorController(GeneratorService service) {
        this.service = service;
    }

    @GetMapping("/generate/scripts")
    public String generateScripts(@RequestParam int from, @RequestParam int to){
        service.generateFile(from, to);
        return "zrobione";
    }


}
