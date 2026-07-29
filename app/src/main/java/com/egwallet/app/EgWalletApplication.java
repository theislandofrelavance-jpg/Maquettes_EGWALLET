package com.egwallet.app;

import android.app.Application;
import com.egwallet.app.data.RepositoryProvider;

public class EgWalletApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Init singletons here (Retrofit/Room later)
        RepositoryProvider.initialize(this);
    }
}
