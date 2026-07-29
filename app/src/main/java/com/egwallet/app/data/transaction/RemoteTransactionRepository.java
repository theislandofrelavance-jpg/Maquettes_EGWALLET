package com.egwallet.app.data.transaction;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.egwallet.app.model.AccountModel;
import com.egwallet.app.model.TransactionModel;

import java.util.List;

public class RemoteTransactionRepository implements TransactionRepository {
    private final MutableLiveData<String> error = new MutableLiveData<>();

    public RemoteTransactionRepository(Context ctx) {
        // real implementation to call ApiService via Retrofit will be added later
    }

    @Override
    public LiveData<List<TransactionModel>> getRecentTransactions() {
        MutableLiveData<List<TransactionModel>> res = new MutableLiveData<>();
        // Not implemented in skeleton
        res.postValue(null);
        return res;
    }

    @Override
    public LiveData<AccountModel> getPrimaryAccount() {
        MutableLiveData<AccountModel> res = new MutableLiveData<>();
        res.postValue(null);
        return res;
    }
}
