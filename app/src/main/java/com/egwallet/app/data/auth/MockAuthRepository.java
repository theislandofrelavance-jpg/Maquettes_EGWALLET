package com.egwallet.app.data.auth;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MockAuthRepository implements AuthRepository {
    private final MutableLiveData<String> error = new MutableLiveData<>();
    private String testPin = "123456"; // stored in mock repo (not in UI)

    public MockAuthRepository(Context ctx) {
        // Could seed mock users here
    }

    @Override
    public LiveData<Boolean> loginWithPin(String pin) {
        MutableLiveData<Boolean> res = new MutableLiveData<>();
        if (testPin.equals(pin)) {
            res.postValue(true);
            error.postValue("");
        } else {
            res.postValue(false);
            error.postValue("PIN incorrect");
        }
        return res;
    }

    @Override
    public LiveData<Boolean> register(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
        MutableLiveData<Boolean> res = new MutableLiveData<>();
        // Basic validation in mock
        if (firstName == null || firstName.isEmpty() || email == null || email.isEmpty()) {
            error.postValue("Champs requis manquants");
            res.postValue(false);
            return res;
        }
        if (!password.equals(confirmPassword)) {
            error.postValue("Les mots de passe ne correspondent pas");
            res.postValue(false);
            return res;
        }
        // Simulate registration success and keep testPin as default
        res.postValue(true);
        error.postValue("");
        return res;
    }

    @Override
    public LiveData<String> getErrorMessage() { return error; }
}
