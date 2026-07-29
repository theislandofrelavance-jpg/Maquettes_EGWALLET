package com.egwallet.app.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.egwallet.app.databinding.ActivitySplashBinding;
import com.egwallet.app.ui.onboarding.OnboardingActivity;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.getRoot().postDelayed(() -> {
            startActivity(new Intent(this, OnboardingActivity.class));
            finish();
        }, 600);
    }
}
