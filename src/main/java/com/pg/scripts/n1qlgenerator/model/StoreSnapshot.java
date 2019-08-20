package com.pg.scripts.n1qlgenerator.model;

import java.util.Set;

import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreAccount;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreActivationStatus;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreCompany;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreConfiguration;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreStatus;
import com.pg.scripts.n1qlgenerator.model.storeRedabbo.StoreTransactions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreSnapshot {

    private String loginPrefix;
    private int numberOfMembers;
    private int tier;
    private boolean corporation;
    private StoreCompany storeCompany;
    private String language;
    private boolean subscription;
    private String creationDate;
    private StoreTransactions transactions;
    private String _class;
    private Set<StoreAccount> accounts;
    private StoreConfiguration storeConfiguration;
    private StoreStatus status;
    private StoreActivationStatus activationStatus;

}
