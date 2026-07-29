package com.egwallet.app.ui.auth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.egwallet.app.R;

public class PinKeyboardView extends LinearLayout {

    public interface OnDigitListener {
        void onDigit(char d);
        void onBackspace();
    }

    private OnDigitListener listener;

    public PinKeyboardView(Context context) {
        this(context, null);
    }

    public PinKeyboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context ctx) {
        LayoutInflater.from(ctx).inflate(R.layout.view_pin_keyboard, this, true);
        int[] ids = new int[]{R.id.k1, R.id.k2, R.id.k3, R.id.k4, R.id.k5, R.id.k6, R.id.k7, R.id.k8, R.id.k9, R.id.k0};
        char[] digits = new char[]{'1','2','3','4','5','6','7','8','9','0'};
        for (int i = 0; i < ids.length; i++) {
            View v = findViewById(ids[i]);
            final char d = digits[i];
            v.setOnClickListener(view -> {
                if (listener != null) listener.onDigit(d);
            });
        }
        ImageButton del = findViewById(R.id.kback);
        del.setOnClickListener(v -> {
            if (listener != null) listener.onBackspace();
        });
    }

    public void setOnDigitListener(OnDigitListener l) {
        this.listener = l;
    }
}
