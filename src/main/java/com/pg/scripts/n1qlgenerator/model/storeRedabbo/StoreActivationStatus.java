package com.pg.scripts.n1qlgenerator.model.storeRedabbo;

public enum StoreActivationStatus {
    ACTIVE, INACTIVE, PENDING;

    public boolean isActive() {
        return this.equals(ACTIVE);
    }
}

