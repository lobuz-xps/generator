package com.pg.scripts.n1qlgenerator.service;

import org.springframework.stereotype.Service;

@Service
public class GeneratorService {

    private final PrepareObjects prepare;

    public GeneratorService(PrepareObjects prepare) {
        this.prepare = prepare;
    }

    public void generateFile() {
        prepare.prepareObjects();
    }

}
