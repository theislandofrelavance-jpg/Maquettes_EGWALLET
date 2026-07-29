package com.egwallet.app.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.egwallet.app.data.RepositoryProvider;
import com.egwallet.app.data.auth.AuthRepository;

public class RegisterViewModel extends AndroidViewModel {
    private final MutableLiveData<Boolean> registerSuccess = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final AuthRepository authRepo;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        authRepo = RepositoryProvider.getAuthRepository();
        authRepo.getErrorMessage().observeForever(s -> {
            if (s != null && !s.isEmpty()) errorMessage.postValue(s);
        });
    }

    public void register(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
        LiveData<Boolean> res = authRepo.register(firstName, lastName, email, phone, password, confirmPassword);
        res.observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean success) {
                if (success != null && success) registerSuccess.postValue(true);
                res.removeObserver(this);
            }
        });
    }

    public LiveData<Boolean> getRegisterSuccess() { return registerSuccess; }
    public LiveData<String> getErrorMessage() { return errorMessage; }
}
