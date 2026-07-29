package com.egwallet.app.data.transaction;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.egwallet.app.model.AccountModel;
import com.egwallet.app.model.TransactionModel;

import java.util.ArrayList;
import java.util.List;

public class MockTransactionRepository implements TransactionRepository {
    private final MutableLiveData<List<TransactionModel>> txLive = new MutableLiveData<>();
    private final MutableLiveData<AccountModel> accountLive = new MutableLiveData<>();

    public MockTransactionRepository(Context ctx) {
        seedData();
    }

    private void seedData() {
        List<TransactionModel> list = new ArrayList<>();
        list.add(new TransactionModel(1, "Courses", "Alimentation", "2026-07-29", 5000, "EXPENSE"));
        list.add(new TransactionModel(2, "Salaire", "Salaire", "2026-07-28", 850000, "INCOME"));
        list.add(new TransactionModel(3, "Remboursement", "Remboursement", "2026-07-27", 30000, "INCOME"));
        list.add(new TransactionModel(4, "Taxi", "Transport", "2026-07-26", 15000, "EXPENSE"));
        txLive.postValue(list);

        AccountModel acc = new AccountModel(1, "Mon Orange Money", "XAF", 2450000);
        accountLive.postValue(acc);
    }

    @Override
    public LiveData<List<TransactionModel>> getRecentTransactions() {
        return txLive;
    }

    @Override
    public LiveData<AccountModel> getPrimaryAccount() {
        return accountLive;
    }
}
