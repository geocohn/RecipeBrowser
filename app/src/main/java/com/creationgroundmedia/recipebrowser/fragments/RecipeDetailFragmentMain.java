package com.creationgroundmedia.recipebrowser.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.creationgroundmedia.recipebrowser.R;
import com.creationgroundmedia.recipebrowser.models.Recipe;

/**
 * Created by geo on 3/22/17.
 */

public class RecipeDetailFragmentMain extends Fragment {
    private static final String RECIPE = "recipe";
    Recipe mRecipe;

    public static RecipeDetailFragmentMain createInstance(Recipe recipe) {
        RecipeDetailFragmentMain fragment = new RecipeDetailFragmentMain();
        Bundle args = new Bundle();
        args.putParcelable(RECIPE, recipe);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecipe = getArguments().getParcelable(RECIPE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail_main, container, false);
        ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);
        Glide.with(this).load(mRecipe.getImageURL()).into(ivImage);
        return view;
    }
}
