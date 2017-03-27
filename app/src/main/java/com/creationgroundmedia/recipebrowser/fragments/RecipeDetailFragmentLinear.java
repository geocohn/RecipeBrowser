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

package com.creationgroundmedia.recipebrowser.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creationgroundmedia.recipebrowser.R;
import com.creationgroundmedia.recipebrowser.models.Recipe;

import static com.creationgroundmedia.recipebrowser.util.Util.buildIngredientsList;
import static com.creationgroundmedia.recipebrowser.util.Util.buildMethodStepsList;

/**
 * Created by geo on 3/22/17.
 */

public class RecipeDetailFragmentLinear extends Fragment {
    private static final String RECIPE = "recipe";
    Recipe mRecipe;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mRecipe = getActivity().getIntent().getParcelableExtra(RECIPE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail_linear, container, false);

        ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);
        TextView tvIngredientsList = (TextView) view.findViewById(R.id.tvIngredientsList);
        TextView tvMethodItemList = (TextView) view.findViewById(R.id.tvMethodItemList);

        Glide.with(this).load(mRecipe.getImageURL()).into(ivImage);
        tvIngredientsList.setText(buildIngredientsList(mRecipe.getIngredients()));
        tvMethodItemList.setText(buildMethodStepsList(mRecipe.getSteps()));

        return view;
    }
}
