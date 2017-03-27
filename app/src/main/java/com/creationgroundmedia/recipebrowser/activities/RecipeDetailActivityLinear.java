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
        setContentView(R.layout.activity_recipe_detail_linear);

        mRecipe = getIntent().getParcelableExtra(RECIPE);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String name = mRecipe.getName();
            if (name != null) {
                actionBar.setTitle(name);
            }
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
