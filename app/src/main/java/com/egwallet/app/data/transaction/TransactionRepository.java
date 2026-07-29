package com.egwallet.app.data.transaction;

import androidx.lifecycle.LiveData;
import java.util.List;
import com.egwallet.app.model.TransactionModel;
import com.egwallet.app.model.AccountModel;

public interface TransactionRepository {
    LiveData<List<TransactionModel>> getRecentTransactions();
    LiveData<AccountModel> getPrimaryAccount();
}
