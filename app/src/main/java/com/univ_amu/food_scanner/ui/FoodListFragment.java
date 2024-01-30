package com.univ_amu.food_scanner.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.univ_amu.food_scanner.data.Repository;
import com.univ_amu.food_scanner.databinding.FragmentFoodListBinding;

public class FoodListFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentFoodListBinding binding = FragmentFoodListBinding.inflate(inflater, container, false);
        /* TODO :
            - créer une instance de Repository

            - créer une instance de FoodListAdapter
            - associer la liste des aliments obtenue via l'instance de Repository
              à l'adaptateur à l'aide de la méthode submitList
            - associer l'adaptateur à la RecyclerView (binding.foodList)
              à l'aide de la méthode setAdapter de RecyclerView
        */
        Repository Repinst=new Repository();
        FoodListAdapter Foodinst=new FoodListAdapter();

        Foodinst.submitList(Repinst.getFoods());
        binding.foodList.setAdapter(Foodinst);

        return binding.getRoot();
    }
}