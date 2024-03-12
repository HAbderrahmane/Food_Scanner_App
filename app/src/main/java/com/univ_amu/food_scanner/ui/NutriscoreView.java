package com.univ_amu.food_scanner.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatTextView;

import com.univ_amu.food_scanner.R;

public class NutriscoreView extends AppCompatTextView {
    public NutriscoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /* TODO :
           - modifier la taille du texte à 24sp (méthode setTextSize)

           - modifier la gravité à Gravity.CENTER (méthode setGravity)
           - modifier la couleur du texte à Color.WHITE (méthode setTextColor)
        */
        setTextSize(24);
        setGravity(Gravity.CENTER);
        setTextColor(Color.WHITE);

    }

    public void setNutriscore(String nutriscore) {
        if (nutriscore == null) return;
        setBackgroundColor(getContext().getResources().getColor(colorId(nutriscore), null));
        /* TODO :
           - afficher le nutriscore avec la méthode setText

        */
        setText(nutriscore);
    }

    private int colorId(String nutriscore) {
        int colorResId;
        switch (nutriscore) {
            case "A":
                colorResId = R.color.nutriscore_A;
                break;
            case "B":
                colorResId = R.color.nutriscore_B;
                break;
            case "C":
                colorResId = R.color.nutriscore_C;
                break;
            case "D":
                colorResId = R.color.nutriscore_D;
                break;
            case "E":
                colorResId = R.color.nutriscore_E;
                break;
            default:
                colorResId = R.color.unknown_nutriscore;
                break;
        }
        return colorResId;

    }
}