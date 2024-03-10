package com.univ_amu.food_scanner.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.univ_amu.food_scanner.data.Food;
import com.univ_amu.food_scanner.databinding.FoodItemBinding;

public class FoodListAdapter extends ListAdapter<Food, FoodListAdapter.ViewHolder> {

    protected FoodListAdapter() {
        super(diffUtilCallback);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FoodItemBinding itemBinding = FoodItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = getItem(position);
        holder.bind(food);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public FoodItemBinding foodItemBinding;
        public Food food;

        public ViewHolder(FoodItemBinding itemBinding) {
            super(itemBinding.getRoot());
            foodItemBinding = itemBinding;
            foodItemBinding.setViewHolder(this);
        }

        public void bind(Food food) {
            this.food = food;
            // Accédez directement aux champs de l'objet Food
            foodItemBinding.name.setText(food.name);
            foodItemBinding.brands.setText(food.brands);
            foodItemBinding.nutriscore.setText(food.nutriscore);
            // Aucun besoin d'appeler invalidateAll() ici
        }
    }

    private static final DiffUtil.ItemCallback<Food> diffUtilCallback =
            new DiffUtil.ItemCallback<Food>() {
                @Override
                public boolean areItemsTheSame(Food oldFood, Food newFood) {
                    return oldFood.code.equals(newFood.code);
                }

                @Override
                public boolean areContentsTheSame(Food oldFood, Food newFood) {
                    // Comparez les champs de l'objet Food pour vérifier si leur contenu est le même
                    if (oldFood.equals(newFood)) return true;
                    else return false;
                }
            };
}