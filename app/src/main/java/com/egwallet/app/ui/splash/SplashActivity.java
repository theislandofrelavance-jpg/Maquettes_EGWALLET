package com.egwallet.app.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.egwallet.app.ui.main.MainActivity;
import com.egwallet.app.R;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Simple auto-forward for skeleton
        findViewById(R.id.splash_root).postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }, 600);
    }
}
