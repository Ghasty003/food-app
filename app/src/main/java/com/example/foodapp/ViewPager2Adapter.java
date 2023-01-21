package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.foodapp.fragments.DrinkFragment;
import com.example.foodapp.fragments.FoodFragment;

public class ViewPager2Adapter extends FragmentStateAdapter {

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new DrinkFragment();

            default:
                return new FoodFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
