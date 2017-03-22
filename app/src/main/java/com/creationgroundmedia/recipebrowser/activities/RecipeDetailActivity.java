package com.creationgroundmedia.recipebrowser.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creationgroundmedia.recipebrowser.R;
import com.creationgroundmedia.recipebrowser.models.Ingredient;
import com.creationgroundmedia.recipebrowser.models.Recipe;

import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {

    private static final String RECIPE = "recipe";

    private Recipe mRecipe;

    public static void start(Context context, Recipe recipe) {
        Intent intent = new Intent(context, RecipeDetailActivity.class);
        intent.putExtra(RECIPE, recipe);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ImageView ivImage = (ImageView) findViewById(R.id.ivImage);
        TextView tvIngredientsList = (TextView) findViewById(R.id.tvIngredientsList);
        TextView tvMethodItemList = (TextView) findViewById(R.id.tvMethodItemList);

        mRecipe = getIntent().getParcelableExtra(RECIPE);

        ActionBar actionBar = getSupportActionBar();
        String name = mRecipe.getName();
        actionBar.setTitle(mRecipe.getName());
        actionBar.setDisplayHomeAsUpEnabled(true);

        Glide.with(this).load(mRecipe.getImageURL()).into(ivImage);
        tvIngredientsList.setText(buildIngredientsList(mRecipe.getIngredients()));
        tvMethodItemList.setText(buildMethodStepsList(mRecipe.getSteps()));
    }

    private CharSequence buildIngredientsList(List<Ingredient> ingredients) {
        StringBuilder builder = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            builder.append(ingredient.getQuantity());
            builder.append(' ');
            builder.append(ingredient.getName());
            builder.append('\n');
        }
        return builder.toString();
    }

    private CharSequence buildMethodStepsList(List<String> steps) {
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
