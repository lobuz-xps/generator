package com.pg.scripts.n1qlgenerator.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Generator {

    private final String path = "/home/maciejl/IdeaProjects/n1ql-generator/src/main/resources/file.n1ql";

    public void createFile(List<String> elements) {


        String insertStore = "INSERT INTO `redabbo` (KEY, VALUE) ";


        StringBuilder builder = new StringBuilder();
        builder.append(insertStore).append(elements.toString());


        try (FileWriter file = new FileWriter(path)) {
            file.write(builder.toString());
        } catch (IOException e) {
            log.info("jeb blad: " + e);
        }
    }

}
