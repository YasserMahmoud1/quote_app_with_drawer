package com.example.quote_app.UI.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quote_app.UI.Fragments.LoginFragment;
import com.example.quote_app.UI.Fragments.RegisterationFragment;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new RegisterationFragment();
        }
        return new LoginFragment();
    }

    @Override
    public int getItemCount() {
        return 2; // Number of tabs
    }
}
