package com.achek.exchangerates.repository.model;

import androidx.annotation.Nullable;

public class ResponseModel {

    public ResponseModel(@Nullable CbrInfo cbrInfo, @Nullable String error) {
        this.cbrInfo = cbrInfo;
        this.error = error;
    }

    @Nullable
    private CbrInfo cbrInfo;

    @Nullable
    private String error;

    @Nullable
    public CbrInfo getCbrInfo() {
        return cbrInfo;
    }

    public void setCbrInfo(@Nullable CbrInfo cbrInfo) {
        this.cbrInfo = cbrInfo;
    }

    @Nullable
    public String getError() {
        return error;
    }

    public void setError(@Nullable String error) {
        this.error = error;
    }
}
