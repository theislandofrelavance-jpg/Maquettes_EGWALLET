package com.egwallet.app;

import android.app.Application;

public class EgWalletApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Init singletons here (Retrofit/Room later)
    }
}
