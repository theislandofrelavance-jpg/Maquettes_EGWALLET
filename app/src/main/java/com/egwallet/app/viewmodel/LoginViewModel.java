package com.egwallet.app.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginViewModel extends AndroidViewModel {
    private final MutableLiveData<Boolean> loginSuccess = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final StringBuilder pin = new StringBuilder();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void appendDigit(char d) {
        if (pin.length() >= 6) return;
        pin.append(d);
        if (pin.length() == 6) {
            attemptLogin(pin.toString());
        }
    }

    public void backspace() {
        if (pin.length() > 0) pin.deleteCharAt(pin.length()-1);
    }

    public String getPin() { return pin.toString(); }

    private void attemptLogin(String pinValue) {
        // Mock behaviour: accept 123456 as valid PIN
        if (BuildConfig.USE_MOCK) {
            if ("123456".equals(pinValue)) {
                loginSuccess.postValue(true);
            } else {
                errorMessage.postValue("PIN incorrect");
                pin.setLength(0);
            }
            return;
        }

        // In real mode, call ApiService -> omitted in skeleton
        errorMessage.postValue("Login not implemented in non-mock mode yet");
        pin.setLength(0);
    }

    public LiveData<Boolean> getLoginSuccess() { return loginSuccess; }
    public LiveData<String> getErrorMessage() { return errorMessage; }
}
