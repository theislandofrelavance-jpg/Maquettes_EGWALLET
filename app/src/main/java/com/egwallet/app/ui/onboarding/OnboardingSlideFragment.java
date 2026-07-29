package com.egwallet.app.ui.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.egwallet.app.databinding.FragmentOnboardingSlideBinding;
import com.egwallet.app.R;

public class OnboardingSlideFragment extends Fragment {
    private static final String ARG_INDEX = "arg_index";
    private FragmentOnboardingSlideBinding binding;

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
        binding = FragmentOnboardingSlideBinding.inflate(inflater, container, false);
        int idx = 0;
        if (getArguments() != null) idx = getArguments().getInt(ARG_INDEX, 0);

        switch (idx) {
            case 1:
                binding.slideImage.setImageResource(R.drawable.objectif1);
                binding.slideTitle.setText("Votre argent,\nsous contrôle total.");
                binding.slideDesc.setText("Revenus, dépenses, dettes, objectifs —\ntout en un seul endroit.");
                break;
            case 2:
                binding.slideImage.setImageResource(R.drawable.onbording3);
                binding.slideTitle.setText("100% hors ligne.\nVos données, votre contrôle.");
                binding.slideDesc.setText("EGWallet fonctionne sans internet.\nLe cloud est là quand vous en avez besoin.");
                break;
            default:
                binding.slideImage.setImageResource(R.drawable.onbording1);
                binding.slideTitle.setText("Chaque décision financière\nvous rapproche de vos objectifs.");
                binding.slideDesc.setText("Gérez votre argent intelligemment,\nmême sans internet.");
                break;
        }

        return binding.getRoot();
    }
}
