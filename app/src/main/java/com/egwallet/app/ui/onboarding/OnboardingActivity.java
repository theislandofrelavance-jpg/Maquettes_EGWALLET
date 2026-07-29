package com.egwallet.app.ui.onboarding;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.egwallet.app.databinding.ActivityOnboardingBinding;
import com.egwallet.app.ui.auth.LoginActivity;

public class OnboardingActivity extends AppCompatActivity {
    private ActivityOnboardingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        OnboardingPagerAdapter adapter = new OnboardingPagerAdapter(this);
        binding.onboardingPager.setAdapter(adapter);

        binding.onboardingSkip.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
