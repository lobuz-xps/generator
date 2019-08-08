package com.pg.scripts.n1qlgenerator.model.storeRedabbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreAccount {
    private String currency;
    private boolean main;

    private StoreAccountWallet prepaid;
    private StoreAccountWallet billing;
    private StoreAccountWallet commission;
}
