package com.creationgroundmedia.recipebrowser.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.creationgroundmedia.recipebrowser.R;
import com.creationgroundmedia.recipebrowser.models.Recipe;

public class RecipeDetailActivityLinear extends AppCompatActivity {

    private static final String RECIPE = "recipe";

    private Recipe mRecipe;

    public static void start(Context context, Recipe recipe) {
        Intent intent = new Intent(context, RecipeDetailActivityLinear.class);
        intent.putExtra(RECIPE, recipe);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail_fragment);

        mRecipe = getIntent().getParcelableExtra(RECIPE);

        ActionBar actionBar = getSupportActionBar();
        String name = mRecipe.getName();
        if (name != null) {
            actionBar.setTitle(name);
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
