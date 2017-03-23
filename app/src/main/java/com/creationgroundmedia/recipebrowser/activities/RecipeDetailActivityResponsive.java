package com.creationgroundmedia.recipebrowser.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.creationgroundmedia.recipebrowser.R;
import com.creationgroundmedia.recipebrowser.adapters.RecipeDetailPagerAdapter;
import com.creationgroundmedia.recipebrowser.fragments.RecipeDetailFragmentIngredients;
import com.creationgroundmedia.recipebrowser.fragments.RecipeDetailFragmentMain;
import com.creationgroundmedia.recipebrowser.fragments.RecipeDetailFragmentMethod;
import com.creationgroundmedia.recipebrowser.models.Recipe;

public class RecipeDetailActivityResponsive extends AppCompatActivity {

    private static final String RECIPE = "recipe";

    private Recipe mRecipe;

    public static void start(Context context, Recipe recipe) {
        Intent intent = new Intent(context, RecipeDetailActivityResponsive.class);
        intent.putExtra(RECIPE, recipe);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail_responsive);

        mRecipe = getIntent().getParcelableExtra(RECIPE);

        ActionBar actionBar = getSupportActionBar();
        String name = mRecipe.getName();
        if (name != null) {
            actionBar.setTitle(name);
        }
        actionBar.setDisplayHomeAsUpEnabled(true);

        ViewPager vpPages = (ViewPager) findViewById(R.id.vpPages);

        if (vpPages != null) {
            vpPages.setAdapter(new RecipeDetailPagerAdapter(getSupportFragmentManager(), mRecipe));
            TabLayout tlTabs = (TabLayout) findViewById(R.id.tlTabs);
            tlTabs.setupWithViewPager(vpPages);
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flMainContainer, RecipeDetailFragmentMain.createInstance(mRecipe))
                    .commit();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flIngredientsContainer, RecipeDetailFragmentIngredients.createInstance(mRecipe))
                    .commit();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flMethodContainer, RecipeDetailFragmentMethod.createInstance(mRecipe))
                    .commit();
        }
    }
}
