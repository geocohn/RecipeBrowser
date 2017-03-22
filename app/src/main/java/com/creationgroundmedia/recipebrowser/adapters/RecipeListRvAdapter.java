package com.creationgroundmedia.recipebrowser.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.creationgroundmedia.recipebrowser.R;
import com.creationgroundmedia.recipebrowser.activities.RecipeDetailActivity;
import com.creationgroundmedia.recipebrowser.models.Recipe;

import java.util.ArrayList;

/**
 * Created by geo on 3/21/17.
 */

public class RecipeListRvAdapter extends RecyclerView.Adapter<RecipeListRvAdapter.ViewHolder> {
    private static final String LOG_TAG = RecipeListRvAdapter.class.getSimpleName();

    final Context mContext;
    private ArrayList<Recipe> mRecipes;

    public RecipeListRvAdapter(Context context, ArrayList<Recipe> recipes) {
        mContext = context;
        mRecipes = recipes;
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
            RecipeDetailActivity.start(mContext, mRecipes.get(position));
        }
    }
}
