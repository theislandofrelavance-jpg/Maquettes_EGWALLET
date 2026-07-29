package com.egwallet.app.ui.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.egwallet.app.R;

public class OnboardingSlideFragment extends Fragment {
    private static final String ARG_INDEX = "arg_index";

    public static OnboardingSlideFragment newInstance(int index) {
        OnboardingSlideFragment f = new OnboardingSlideFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_INDEX, index);
        f.setArguments(b);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_onboarding_slide, container, false);
        int idx = 0;
        if (getArguments() != null) idx = getArguments().getInt(ARG_INDEX, 0);

        ImageView iv = root.findViewById(R.id.slide_image);
        TextView title = root.findViewById(R.id.slide_title);
        TextView desc = root.findViewById(R.id.slide_desc);

        switch (idx) {
            case 1:
                iv.setImageResource(R.drawable.objectif1);
                title.setText("Votre argent,\nsous contrôle total.");
                desc.setText("Revenus, dépenses, dettes, objectifs —\ntout en un seul endroit.");
                break;
            case 2:
                iv.setImageResource(R.drawable.onbording3);
                title.setText("100% hors ligne.\nVos données, votre contrôle.");
                desc.setText("EGWallet fonctionne sans internet.\nLe cloud est là quand vous en avez besoin.");
                break;
            default:
                iv.setImageResource(R.drawable.onbording1);
                title.setText("Chaque décision financière\nvous rapproche de vos objectifs.");
                desc.setText("Gérez votre argent intelligemment,\nmême sans internet.");
                break;
        }

        return root;
    }
}
