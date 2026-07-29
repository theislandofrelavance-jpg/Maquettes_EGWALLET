package com.egwallet.app.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.egwallet.app.databinding.FragmentDashboardBinding;
import com.egwallet.app.model.TransactionModel;
import com.egwallet.app.viewmodel.DashboardViewModel;
import java.util.List;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;
    private DashboardViewModel viewModel;
    private TransactionListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        adapter = new TransactionListAdapter();
        binding.recyclerTransactions.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerTransactions.setAdapter(adapter);

        viewModel.getPrimaryAccount().observe(getViewLifecycleOwner(), account -> {
            if (account != null) {
                binding.balanceAmount.setText(String.format("%s %s", account.balance, account.currency));
            }
        });

        viewModel.getRecentTransactions().observe(getViewLifecycleOwner(), transactions -> {
            if (transactions != null) adapter.submitList(transactions);
        });

        return binding.getRoot();
    }
}
