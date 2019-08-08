package com.pg.scripts.n1qlgenerator.model.storeRedabbo;

import lombok.Data;

@Data
public class StoreConfigurationExclusion {

    private String name;
    private String date;
    private String timeOfDayBegin;
    private String timeOfDayEnd;
}
