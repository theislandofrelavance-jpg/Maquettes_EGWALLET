package com.egwallet.app.data.auth;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RemoteAuthRepository implements AuthRepository {
    private final MutableLiveData<String> error = new MutableLiveData<>();
    private final Context ctx;

    public RemoteAuthRepository(Context ctx) {
        this.ctx = ctx;
        // In real implementation, inject ApiService/ApiClient
    }

    @Override
    public LiveData<Boolean> loginWithPin(String pin) {
        MutableLiveData<Boolean> res = new MutableLiveData<>();
        // Remote login by PIN is not standard; the app should use email/password endpoints.
        // For now, return error indicating not implemented.
        error.postValue("Login par PIN non implémenté en mode remote");
        res.postValue(false);
        return res;
    }

    @Override
    public LiveData<Boolean> register(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
        MutableLiveData<Boolean> res = new MutableLiveData<>();
        // Real implementation should call ApiService.register
        error.postValue("Register remote non implémenté dans le skeleton");
        res.postValue(false);
        return res;
    }

    @Override
    public LiveData<String> getErrorMessage() { return error; }
}
