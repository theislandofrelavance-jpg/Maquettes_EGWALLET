package com.egwallet.app.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.egwallet.app.databinding.ItemTransactionBinding;
import com.egwallet.app.model.TransactionModel;

public class TransactionListAdapter extends ListAdapter<TransactionModel, TransactionListAdapter.VH> {
    protected TransactionListAdapter() {
        super(DIFF);
    }

    private static final DiffUtil.ItemCallback<TransactionModel> DIFF = new DiffUtil.ItemCallback<TransactionModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull TransactionModel oldItem, @NonNull TransactionModel newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull TransactionModel oldItem, @NonNull TransactionModel newItem) {
            return oldItem.name.equals(newItem.name) && oldItem.amount == newItem.amount && oldItem.date.equals(newItem.date);
        }
    };

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTransactionBinding b = ItemTransactionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new VH(b);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        TransactionModel t = getItem(position);
        holder.bind(t);
    }

    static class VH extends RecyclerView.ViewHolder {
        private final ItemTransactionBinding binding;

        VH(ItemTransactionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(TransactionModel t) {
            binding.tvTxName.setText(t.name + " • " + t.category);
            binding.tvTxAmount.setText((t.type.equals("INCOME") ? "+" : "-") + String.valueOf(t.amount));
            if (t.type.equals("INCOME")) {
                binding.tvTxAmount.setTextColor(binding.getRoot().getResources().getColor(com.egwallet.app.R.color.income_green));
            } else {
                binding.tvTxAmount.setTextColor(binding.getRoot().getResources().getColor(com.egwallet.app.R.color.expense_red));
            }
        }
    }
}
