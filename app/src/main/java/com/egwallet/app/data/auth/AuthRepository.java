package com.egwallet.app.data.auth;

import androidx.lifecycle.LiveData;

public interface AuthRepository {
    // Attempt login using a 6-digit PIN (local or remote)
    LiveData<Boolean> loginWithPin(String pin);

    // Register a new user. Returns LiveData<Boolean> for success.
    LiveData<Boolean> register(String firstName, String lastName, String email, String phone, String password, String confirmPassword);

    // Expose last error message if any
    LiveData<String> getErrorMessage();
}
