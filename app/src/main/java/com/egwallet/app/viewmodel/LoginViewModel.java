package com.egwallet.app.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.egwallet.app.data.RepositoryProvider;
import com.egwallet.app.data.auth.AuthRepository;

public class LoginViewModel extends AndroidViewModel {
    private final MutableLiveData<Boolean> loginSuccess = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final StringBuilder pin = new StringBuilder();
    private final AuthRepository authRepo;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        authRepo = RepositoryProvider.getAuthRepository();
        // Observe repository error messages
        authRepo.getErrorMessage().observeForever(s -> {
            if (s != null && !s.isEmpty()) errorMessage.postValue(s);
        });
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
        LiveData<Boolean> res = authRepo.loginWithPin(pinValue);
        // Observe once
        res.observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean success) {
                if (success != null && success) {
                    loginSuccess.postValue(true);
                } else {
                    // errorMessage is set by repository
                    pin.setLength(0);
                }
                res.removeObserver(this);
            }
        });
    }

    public LiveData<Boolean> getLoginSuccess() { return loginSuccess; }
    public LiveData<String> getErrorMessage() { return errorMessage; }
}
