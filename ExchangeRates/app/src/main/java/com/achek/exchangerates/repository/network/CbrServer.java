package com.achek.exchangerates.repository.network;

import com.achek.exchangerates.di.DaggerAppComponent;
import com.achek.exchangerates.di.DataModule;
import com.achek.exchangerates.repository.async.CallBack;
import com.achek.exchangerates.repository.model.CbrInfo;
import com.achek.exchangerates.repository.model.ResponseModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CbrServer {

    public CbrServer() {
        DaggerAppComponent.builder().dataModule(new DataModule()).build().injectCbrServer(this);
    }

    @Inject
    Retrofit retrofit;

    private CbrInfo cbrInfo;
    private String errorString;

    public void getRatesInfo(final CallBack iCallback) {

        CbrAPI cbrAPI = retrofit.create(CbrAPI.class);
        final Call<CbrInfo> ratesInfoCall = cbrAPI.getCbrInfoJSON();

        ratesInfoCall.enqueue(new Callback<CbrInfo>() {

            @Override
            public void onResponse(Call<CbrInfo> call, Response<CbrInfo> response) {
                if (response.isSuccessful()) {
                    cbrInfo = response.body();
                } else {
                    cbrInfo = null;
                }
                iCallback.callingBack(new ResponseModel(cbrInfo, errorString));
            }

            @Override
            public void onFailure(Call<CbrInfo> call, Throwable t) {
                errorString += "failure " + t;
                iCallback.callingBack(new ResponseModel(cbrInfo, errorString));
            }
        });
    }
}