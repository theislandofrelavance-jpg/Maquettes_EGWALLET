package com.egwallet.app.ui.auth;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.egwallet.app.databinding.ActivityRegisterBinding;
import com.egwallet.app.viewmodel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        binding.registerButton.setOnClickListener(v -> {
            String first = binding.firstName.getText().toString();
            String last = binding.lastName.getText().toString();
            String email = binding.email.getText().toString();
            String phone = binding.phone.getText().toString();
            String pass = binding.password.getText().toString();
            String confirm = binding.confirmPassword.getText().toString();

            viewModel.register(first, last, email, phone, pass, confirm);
        });

        viewModel.getRegisterSuccess().observe(this, success -> {
            if (success != null && success) {
                Toast.makeText(this, "Compte créé (mock)", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        viewModel.getErrorMessage().observe(this, msg -> {
            if (msg != null && !msg.isEmpty()) Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });
    }
}
