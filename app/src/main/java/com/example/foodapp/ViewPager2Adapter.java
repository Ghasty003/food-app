package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.foodapp.fragments.DrinkFragment;
import com.example.foodapp.fragments.FishFragment;
import com.example.foodapp.fragments.FoodFragment;
import com.example.foodapp.fragments.FruitFragment;
import com.example.foodapp.fragments.IceCreamFragment;
import com.example.foodapp.fragments.SnackFragment;

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

            case 2:
                return new FruitFragment();

            case 3:
                return new SnackFragment();

            case 4:
                return new IceCreamFragment();

            case 5:
                return new FishFragment();

            default:
                return new FoodFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
