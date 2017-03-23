package com.creationgroundmedia.recipebrowser.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.creationgroundmedia.recipebrowser.fragments.RecipeDetailFragmentIngredients;
import com.creationgroundmedia.recipebrowser.fragments.RecipeDetailFragmentMain;
import com.creationgroundmedia.recipebrowser.fragments.RecipeDetailFragmentMethod;
import com.creationgroundmedia.recipebrowser.models.Recipe;

/**
 * Created by geo on 3/22/17.
 */

public class RecipeDetailPagerAdapter extends FragmentStatePagerAdapter {
    private final Recipe mRecipe;

    public RecipeDetailPagerAdapter(FragmentManager fm, Recipe recipe) {
        super(fm);
        mRecipe = recipe;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return RecipeDetailFragmentMain.createInstance(mRecipe);
            case 1: return RecipeDetailFragmentIngredients.createInstance(mRecipe);
            case 2: return RecipeDetailFragmentMethod.createInstance(mRecipe);
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Main Details";
            case 1: return "Ingredients";
            case 2: return "Method";
        }
        return null;
    }
}
