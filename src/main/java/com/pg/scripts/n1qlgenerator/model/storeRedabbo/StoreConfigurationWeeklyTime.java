package com.pg.scripts.n1qlgenerator.model.storeRedabbo;

import lombok.Data;

@Data
public class StoreConfigurationWeeklyTime {

    private Integer dayOfWeek;
    private String timeOfDayBegin;
    private String timeOfDayEnd;

}
