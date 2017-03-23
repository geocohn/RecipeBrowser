package com.creationgroundmedia.recipebrowser.util;

import com.creationgroundmedia.recipebrowser.models.Ingredient;

import java.util.List;

/**
 * Created by geo on 3/23/17.
 */

public class Util {
    public static CharSequence buildIngredientsList(List<Ingredient> ingredients) {
        StringBuilder builder = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            builder.append(ingredient.getQuantity());
            builder.append(' ');
            builder.append(ingredient.getName());
            builder.append('\n');
        }
        return builder.toString();
    }

    public static CharSequence buildMethodStepsList(List<String> steps) {
        StringBuilder builder = new StringBuilder();
        for (String step : steps) {
            builder.append('‣');
            builder.append(' ');
            builder.append(step);
            builder.append('\n');
        }
        return builder.toString();
    }
}
