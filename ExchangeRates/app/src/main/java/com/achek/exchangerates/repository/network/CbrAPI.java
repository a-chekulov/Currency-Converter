package com.achek.exchangerates.repository.network;

import com.achek.exchangerates.repository.model.CbrInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CbrAPI {
    @GET("daily_json.js")
    Call<CbrInfo> getCbrInfoJSON();
}
