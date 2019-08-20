package com.pg.scripts.n1qlgenerator.generator;

import static java.util.Objects.nonNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Generator {

    private static final String PATH = "file.n1ql";

    public void createFile(List<String> elements) {

        String insertStore = "INSERT INTO `redabbo` (KEY, VALUE) ";


        StringBuilder builder = new StringBuilder();
        builder.append(insertStore).append(elements.toString());

        File file = null;
        try {
            file = new ClassPathResource(PATH).getFile();
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(builder.toString());
        } catch (IOException e) {
            log.info("jeb blad: " + e);
        }
    }

}
