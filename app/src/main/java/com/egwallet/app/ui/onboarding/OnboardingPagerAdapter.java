package com.egwallet.app.ui.onboarding;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class OnboardingPagerAdapter extends FragmentStateAdapter {
    public OnboardingPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public androidx.fragment.app.Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return OnboardingSlideFragment.newInstance(1);
            case 2:
                return OnboardingSlideFragment.newInstance(2);
            default:
                return OnboardingSlideFragment.newInstance(0);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
