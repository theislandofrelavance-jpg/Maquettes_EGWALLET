package com.egwallet.app.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ApiService {
    @GET("accounts")
    Call<Object> getAccounts(@Header("Authorization") String bearer);

    @GET("accounts/{id}")
    Call<Object> getAccount(@Path("id") long id, @Header("Authorization") String bearer);
}
