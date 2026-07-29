package com.egwallet.app.ui.auth;

import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.viewModels;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.egwallet.app.R;
import com.egwallet.app.viewmodel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {
    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        findViewById(R.id.register_button).setOnClickListener(v -> {
            String first = ((android.widget.EditText)findViewById(R.id.firstName)).getText().toString();
            String last = ((android.widget.EditText)findViewById(R.id.lastName)).getText().toString();
            String email = ((android.widget.EditText)findViewById(R.id.email)).getText().toString();
            String phone = ((android.widget.EditText)findViewById(R.id.phone)).getText().toString();
            String pass = ((android.widget.EditText)findViewById(R.id.password)).getText().toString();
            String confirm = ((android.widget.EditText)findViewById(R.id.confirmPassword)).getText().toString();

            viewModel.register(first, last, email, phone, pass, confirm);
        });

        viewModel.getRegisterSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean success) {
                if (success != null && success) {
                    Toast.makeText(RegisterActivity.this, "Compte créé (mock)", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        viewModel.getErrorMessage().observe(this, msg -> {
            if (msg != null && !msg.isEmpty()) Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });
    }
}
