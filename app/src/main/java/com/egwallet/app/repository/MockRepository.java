package com.egwallet.app.repository;

import android.content.Context;
import com.egwallet.app.data.local.AppDatabase;

public class MockRepository {
    private final AppDatabase db;

    public MockRepository(Context context) {
        db = AppDatabase.getInstance(context);
    }

    // Example stubs
    public void seedSampleData() {
        // write sample transactions to DB on background thread
    }
}
