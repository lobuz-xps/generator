package com.pg.scripts.n1qlgenerator.model.storeRedabbo;

import java.util.List;

import lombok.Data;

@Data
public class StoreConfigurationDetails {

    private String storeName;

    private String country;

    private String postalCode;

    private String city;

    private String street;

    private String url;

    private String facebookUrl;

    private String description;

    private Integer categoryId;

    private Integer subcategoryId;

    private Integer discount;

    private List<StoreConfigurationWeeklyTime> dailyBusinessHours;

    private List<StoreConfigurationExclusion> exclusions;

    private StoreConfigurationLocation location;

    private String timeZone;

}
