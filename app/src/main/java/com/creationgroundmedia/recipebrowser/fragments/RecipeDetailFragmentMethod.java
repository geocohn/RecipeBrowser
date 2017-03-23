package com.creationgroundmedia.recipebrowser.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.creationgroundmedia.recipebrowser.R;
import com.creationgroundmedia.recipebrowser.models.Recipe;

import java.util.List;

/**
 * Created by geo on 3/22/17.
 */

public class RecipeDetailFragmentMethod extends Fragment {
    private static final String RECIPE = "recipe";
    Recipe mRecipe;

    public static RecipeDetailFragmentMethod createInstance(Recipe recipe) {
        RecipeDetailFragmentMethod fragment = new RecipeDetailFragmentMethod();
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
        View view = inflater.inflate(R.layout.fragment_recipe_detail_method, container, false);
        TextView tvMethodItemList = (TextView) view.findViewById(R.id.tvMethodItemList);
        tvMethodItemList.setText(buildMethodStepsList(mRecipe.getSteps()));
        return view;
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
