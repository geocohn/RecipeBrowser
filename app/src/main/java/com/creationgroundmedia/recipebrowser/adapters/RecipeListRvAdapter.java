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

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creationgroundmedia.recipebrowser.R;
import com.creationgroundmedia.recipebrowser.activities.RecipeDetailActivityLinear;
import com.creationgroundmedia.recipebrowser.activities.RecipeDetailActivityResponsive;
import com.creationgroundmedia.recipebrowser.models.Recipe;

import java.util.ArrayList;

/**
 * Created by geo on 3/21/17.
 */

public class RecipeListRvAdapter extends RecyclerView.Adapter<RecipeListRvAdapter.ViewHolder> {
    private static final String LOG_TAG = RecipeListRvAdapter.class.getSimpleName();

    final Context mContext;
    private ArrayList<Recipe> mRecipes;
    private SwitchState mSwitchState;

    public RecipeListRvAdapter(Context context, ArrayList<Recipe> recipes) {
        mContext = context;
        mRecipes = recipes;
        if (context instanceof SwitchState) {
            mSwitchState = (SwitchState) context;
        } else {
            throw new RuntimeException("Class creating "
                    + RecipeListRvAdapter.class.getSimpleName()
                    + " needs to implement SwitchState");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new ViewHolder(inflater.inflate(R.layout.recipe_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recipe recipe = mRecipes.get(position);
//        Log.d(LOG_TAG, "onBindViewHolder imageUrl = " + recipe.getImageURL());
//        Log.d(LOG_TAG, "onBindViewHolder name = " + recipe.getName());
        Glide.with(mContext)
                .load(recipe.getImageURL())
                .into(holder.ivImage);
        holder.tvName.setText(recipe.getName());
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivImage;
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);

            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position == RecyclerView.NO_POSITION) return;
            if (mSwitchState.getState()) {
                RecipeDetailActivityResponsive.start(mContext, mRecipes.get(position));
            } else {
                RecipeDetailActivityLinear.start(mContext, mRecipes.get(position));
            }
        }
    }

    public interface SwitchState {
        boolean getState();
    }
}
