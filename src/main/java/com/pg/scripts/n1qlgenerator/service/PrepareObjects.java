package com.pg.scripts.n1qlgenerator.service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pg.scripts.n1qlgenerator.generator.Generator;
import com.pg.scripts.n1qlgenerator.generator.IdGenerator;
import com.pg.scripts.n1qlgenerator.model.StoreSnapshot;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreAccount;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreAccountWallet;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreActivationStatus;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreCompany;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreConfiguration;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreConfigurationDetails;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreConfigurationExclusion;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreConfigurationLocation;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreConfigurationWeeklyTime;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreStatus;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreTransactions;

@Component
public class PrepareObjects {

    private final Generator generator;

    public PrepareObjects(Generator generator) {
        this.generator = generator;
    }


    public void prepareObjects(int from, int to) {

        ObjectMapper mapper = new ObjectMapper();
        StoreSnapshot storeRedabbo = new StoreSnapshot();

        StoreCompany storeCompany = new StoreCompany();
        StoreConfigurationDetails storeConfigurationDetails = new StoreConfigurationDetails();
        StoreConfiguration storeConfiguration = new StoreConfiguration();
        StoreConfigurationLocation storeConfigurationLocation = new StoreConfigurationLocation();
        StoreStatus storeStatus = new StoreStatus();
        StoreTransactions transactions = new StoreTransactions();
        StoreAccount account = new StoreAccount();
        StoreAccountWallet wallet = new StoreAccountWallet();

        List<String> elements = new ArrayList<>();

        String values = "VALUES (\"{0}\", {1}) ";
        String clazz = "com.pg.core.crm.store.registration.snapshot.StoreSnapshot";

        long phoneNumber = 999888777;

        for (int i = from; i < to; i++) {
            List<StoreConfigurationExclusion> exclusions = new ArrayList<>();
            List<StoreConfigurationWeeklyTime> weeklyTimes = new ArrayList<>();

            String storeId = IdGenerator.generate();

            storeCompany.setLastName(i + "lastname");
            storeCompany.setCountry("Polska");
            storeCompany.setCity("Warszawa");
            storeCompany.setCompanyName("zabka " + i);
            storeCompany.setPhoneNumber("48" + phoneNumber + "");
            storeCompany.setEmail(i + "mail@nvt.pl");
            storeCompany.setPostalCode("12-3456");
            storeCompany.setTaxNumber("12345678");
            storeCompany.setFirstName(i + "first");
            storeCompany.setModificationDate("2019-03-01T10:00:00.000001Z");
            storeCompany.setStreet("blada");
            storeCompany.setBankAccountNumber("82 1020 5226 0000 8399 0420 7895");

            storeConfigurationLocation.setLat(IdGenerator.getLat());
            storeConfigurationLocation.setLon(IdGenerator.getLon());

            for (int o = 1; o <= 7; o++) {
                StoreConfigurationWeeklyTime weeklyTime = new StoreConfigurationWeeklyTime();
                weeklyTime.setDayOfWeek(o);
                weeklyTime.setTimeOfDayBegin("02:00");
                weeklyTime.setTimeOfDayEnd("20:00");
                weeklyTimes.add(weeklyTime);
            }

            int catId = IdGenerator.categoryId();

            switch (catId) {
                case 1:
                    storeConfigurationDetails.setCategoryId(catId);
                    storeConfigurationDetails.setSubcategoryId(1);
                    break;
                case 2:
                    storeConfigurationDetails.setCategoryId(catId);
                    storeConfigurationDetails.setSubcategoryId(0);
                    break;
                case 3:
                    storeConfigurationDetails.setCategoryId(catId);
                    storeConfigurationDetails.setSubcategoryId(1);
                    break;
                case 4:
                    storeConfigurationDetails.setCategoryId(catId);
                    storeConfigurationDetails.setSubcategoryId(1);
                    break;
                case 5:
                    storeConfigurationDetails.setCategoryId(catId);
                    storeConfigurationDetails.setSubcategoryId(0);
                    break;
                case 6:
                    storeConfigurationDetails.setCategoryId(catId);
                    storeConfigurationDetails.setSubcategoryId(2);
                    break;
                case 7:
                    storeConfigurationDetails.setCategoryId(catId);
                    storeConfigurationDetails.setSubcategoryId(2);
                    break;
            }

            storeConfigurationDetails.setLocation(storeConfigurationLocation);
            storeConfigurationDetails.setDiscount(IdGenerator.getDiscount());
            storeConfigurationDetails.setDailyBusinessHours(weeklyTimes);
            storeConfigurationDetails.setTimeZone("Europe/Warsaw");
            storeConfigurationDetails.setCity("Warszawa");
            storeConfigurationDetails.setCountry("Polska");
            storeConfigurationDetails.setPostalCode("12-3456");
            storeConfigurationDetails.setStreet("blada");
            storeConfigurationDetails.setStoreName("zabka " + i);
            storeConfigurationDetails.setUrl("www." + i + ".pl");
            storeConfigurationDetails.setDescription("opis: " + i);
            storeConfigurationDetails.setExclusions(exclusions);
            storeConfiguration.setDetails(storeConfigurationDetails);

            storeStatus.setActive(true);
            storeStatus.setBlocked(false);

            transactions.setSystemCommission(BigDecimal.ZERO);

            wallet.setBalance(BigDecimal.valueOf(100));
            account.setCurrency("PLN");
            account.setMain(true);
            account.setPrepaid(wallet);
            account.setBilling(wallet);
            account.setCommission(wallet);

            Set<StoreAccount> storeAccounts = new HashSet<>();
            storeAccounts.add(account);

            storeRedabbo.setLoginPrefix(IdGenerator.getPrefixLogin() + "-" + IdGenerator.getPrefixLogin());
            storeRedabbo.setNumberOfMembers(0);
            storeRedabbo.setCorporation(false);
            storeRedabbo.setStoreCompany(storeCompany);
            storeRedabbo.setLanguage("pl");
            storeRedabbo.setSubscription(false);
            storeRedabbo.setCreationDate("2018-01-01T10:00:00.000001Z");
            storeRedabbo.setTransactions(transactions);
            storeRedabbo.set_class(clazz);
            storeRedabbo.setAccounts(storeAccounts);
            storeRedabbo.setStoreConfiguration(storeConfiguration);
            storeRedabbo.setStatus(storeStatus);
            storeRedabbo.setTier(0);
            storeRedabbo.setActivationStatus(StoreActivationStatus.ACTIVE);
            String toSave = "";

            try {
                toSave = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(storeRedabbo);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            String format = MessageFormat.format(values, storeId, toSave);

            elements.add(format);
            phoneNumber--;
        }
        generator.createFile(elements);

    }
}
