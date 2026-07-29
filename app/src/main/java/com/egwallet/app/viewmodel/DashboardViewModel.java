package com.egwallet.app.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.egwallet.app.data.RepositoryProvider;
import com.egwallet.app.data.transaction.TransactionRepository;
import com.egwallet.app.model.AccountModel;
import com.egwallet.app.model.TransactionModel;

import java.util.List;

public class DashboardViewModel extends AndroidViewModel {
    private final TransactionRepository txRepo;

    public DashboardViewModel(@NonNull Application application) {
        super(application);
        txRepo = RepositoryProvider.getTransactionRepository();
    }

    public LiveData<AccountModel> getPrimaryAccount() {
        return txRepo.getPrimaryAccount();
    }

    public LiveData<List<TransactionModel>> getRecentTransactions() {
        return txRepo.getRecentTransactions();
    }
}
