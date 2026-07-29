package com.egwallet.app.data;

import android.content.Context;
import com.egwallet.app.data.auth.AuthRepository;
import com.egwallet.app.data.auth.MockAuthRepository;
import com.egwallet.app.data.auth.RemoteAuthRepository;

public class RepositoryProvider {
    private static AuthRepository authRepository;

    public static void initialize(Context ctx) {
        if (authRepository != null) return;
        if (BuildConfig.USE_MOCK) {
            authRepository = new MockAuthRepository(ctx);
        } else {
            authRepository = new RemoteAuthRepository(ctx);
        }
    }

    public static AuthRepository getAuthRepository() {
        if (authRepository == null) throw new IllegalStateException("RepositoryProvider not initialized");
        return authRepository;
    }
}
