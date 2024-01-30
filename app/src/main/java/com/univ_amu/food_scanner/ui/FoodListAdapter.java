package com.univ_amu.food_scanner.ui;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.univ_amu.food_scanner.data.Food;

public class FoodListAdapter extends ListAdapter<Food, FoodListAdapter.ViewHolder> {

    FoodListAdapter() {
        super(diffUtilCallback);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = getItem(position);
        holder.bind(food);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;

        }

        void bind(Food food) { textView.setText(food.name); }

    }

    private static final DiffUtil.ItemCallback<Food> diffUtilCallback =
            new DiffUtil.ItemCallback<Food>() {
                @Override
                public boolean areItemsTheSame(Food oldFood, Food newFood) {
                    return oldFood.code.equals(newFood.code);
                }
                @Override
                public boolean areContentsTheSame(Food oldFood, Food newFood) {
                    return this.areItemsTheSame(oldFood, newFood);
                }
            };

}