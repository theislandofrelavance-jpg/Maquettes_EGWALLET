package com.egwallet.app.data;

import android.content.Context;

import com.egwallet.app.data.auth.AuthRepository;
import com.egwallet.app.data.auth.MockAuthRepository;
import com.egwallet.app.data.auth.RemoteAuthRepository;
import com.egwallet.app.data.transaction.MockTransactionRepository;
import com.egwallet.app.data.transaction.RemoteTransactionRepository;
import com.egwallet.app.data.transaction.TransactionRepository;

public class RepositoryProvider {
    private static AuthRepository authRepository;
    private static TransactionRepository transactionRepository;

    public static void initialize(Context ctx) {
        if (authRepository != null && transactionRepository != null) return;
        if (BuildConfig.USE_MOCK) {
            authRepository = new MockAuthRepository(ctx);
            transactionRepository = new MockTransactionRepository(ctx);
        } else {
            authRepository = new RemoteAuthRepository(ctx);
            transactionRepository = new RemoteTransactionRepository(ctx);
        }
    }

    public static AuthRepository getAuthRepository() {
        if (authRepository == null) throw new IllegalStateException("RepositoryProvider not initialized");
        return authRepository;
    }

    public static TransactionRepository getTransactionRepository() {
        if (transactionRepository == null) throw new IllegalStateException("RepositoryProvider not initialized");
        return transactionRepository;
    }
}
