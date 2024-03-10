package com.univ_amu.food_scanner.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.univ_amu.food_scanner.databinding.FragmentFoodBinding;

public class FoodFragment extends Fragment {

    private FragmentFoodBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Use data binding to inflate the fragment view
        binding = FragmentFoodBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Set the text for the TextView with the ID "code"
        binding.code.setText("FoodFragment");

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Release the reference to the binding when it's no longer needed
    }
}
