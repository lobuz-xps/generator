package com.pg.scripts.n1qlgenerator.model.storeRedabbo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StoreConfiguration {

    private StoreConfigurationDetails details;

    private String logoPath;

    private List<String> photoPaths = new ArrayList<>();



}
