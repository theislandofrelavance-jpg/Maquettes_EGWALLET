package com.egwallet.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.viewModels;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.egwallet.app.R;
import com.egwallet.app.ui.main.MainActivity;
import com.egwallet.app.viewmodel.LoginViewModel;
import com.egwallet.app.ui.auth.PinKeyboardView;

public class LoginActivity extends AppCompatActivity {
    private final LoginViewModel viewModel by viewModels();
    private TextView[] dots = new TextView[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dots[0] = findViewById(R.id.dot1);
        dots[1] = findViewById(R.id.dot2);
        dots[2] = findViewById(R.id.dot3);
        dots[3] = findViewById(R.id.dot4);
        dots[4] = findViewById(R.id.dot5);
        dots[5] = findViewById(R.id.dot6);

        PinKeyboardView keyboard = findViewById(R.id.pin_keyboard);
        keyboard.setOnDigitListener(new PinKeyboardView.OnDigitListener() {
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

        viewModel.getLoginSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean success) {
                if (success != null && success) {
                    // Navigate to Main
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        });

        viewModel.getErrorMessage().observe(this, msg -> {
            if (msg != null && !msg.isEmpty()) {
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateDots(String pin) {
        int len = pin.length();
        for (int i = 0; i < 6; i++) {
            if (i < len) {
                dots[i].setText("●");
            } else {
                dots[i].setText("○");
            }
        }
    }
}
