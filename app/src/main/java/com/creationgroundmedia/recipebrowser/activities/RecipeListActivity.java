package com.creationgroundmedia.recipebrowser.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

import com.creationgroundmedia.recipebrowser.R;
import com.creationgroundmedia.recipebrowser.adapters.RecipeListRvAdapter;
import com.creationgroundmedia.recipebrowser.models.Recipe;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class RecipeListActivity extends AppCompatActivity implements RecipeListRvAdapter.SwitchState {

    private static final String LOG_TAG = RecipeListActivity.class.getSimpleName();
    private static final String RESPONSIVE = "responsive";
    private SwitchCompat swResponsive;
    private boolean isResponsive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        isResponsive = sharedPref.getBoolean(RESPONSIVE, true);

        setContentView(R.layout.activity_recipe_list);

        ArrayList<Recipe> recipes = getRecipesFromAsset("Recipes.json");

        RecyclerView rvRecipeList = (RecyclerView) findViewById(R.id.rvRecipeList);
        RecipeListRvAdapter adapter = new RecipeListRvAdapter(this, recipes);
        rvRecipeList.setAdapter(adapter);
        rvRecipeList.setLayoutManager(new LinearLayoutManager(this));
    }

    private ArrayList<Recipe> getRecipesFromAsset(String assetName) {
        String json = readAsset("Recipes.json");
        Gson gson = new Gson();
        Recipe[] recipes = gson.fromJson(json, Recipe[].class);
        return new ArrayList<>(Arrays.asList(recipes));
    }

    private String readAsset(String assetName) {
        String json = null;

        try {
            InputStream inputStream = getAssets().open(assetName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        swResponsive = (SwitchCompat) menu.findItem(R.id.miResponsive)
                .getActionView()
                .findViewById(R.id.swResponsive);
        swResponsive.setChecked(isResponsive);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(RESPONSIVE, getState());
        editor.apply();
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean getState() {
        return swResponsive.isChecked();
    }
}
