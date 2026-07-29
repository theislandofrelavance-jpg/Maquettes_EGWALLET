package com.egwallet.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.viewModels;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.egwallet.app.databinding.ActivityLoginBinding;
import com.egwallet.app.ui.main.MainActivity;
import com.egwallet.app.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding.pinKeyboard.setOnDigitListener(new com.egwallet.app.ui.auth.PinKeyboardView.OnDigitListener() {
            @Override
            public void onDigit(char d) {
                viewModel.appendDigit(d);
                updateDots(viewModel.getPin());
            }

            @Override
            public void onBackspace() {
                viewModel.backspace();
                updateDots(viewModel.getPin());
            }
        });

        viewModel.getLoginSuccess().observe(this, success -> {
            if (success != null && success) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });

        viewModel.getErrorMessage().observe(this, msg -> {
            if (msg != null && !msg.isEmpty()) {
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        updateDots("");
    }

    private void updateDots(String pin) {
        int len = pin.length();
        binding.dot1.setText(len > 0 ? "●" : "○");
        binding.dot2.setText(len > 1 ? "●" : "○");
        binding.dot3.setText(len > 2 ? "●" : "○");
        binding.dot4.setText(len > 3 ? "●" : "○");
        binding.dot5.setText(len > 4 ? "●" : "○");
        binding.dot6.setText(len > 5 ? "●" : "○");
    }
}
