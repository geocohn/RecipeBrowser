/*
 * Copyright 2017 George Cohn III
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
