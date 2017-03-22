
package com.creationgroundmedia.recipebrowser.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Recipe implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ingredients")
    @Expose
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    @SerializedName("steps")
    @Expose
    private List<String> steps = new ArrayList<String>();
    @SerializedName("timers")
    @Expose
    private List<Integer> timers = new ArrayList<Integer>();
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("originalURL")
    @Expose
    private String originalURL;
    public final static Parcelable.Creator<Recipe> CREATOR = new Creator<Recipe>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Recipe createFromParcel(Parcel in) {
            Recipe instance = new Recipe();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.ingredients, (Ingredient.class.getClassLoader()));
            in.readList(instance.steps, (java.lang.String.class.getClassLoader()));
            in.readList(instance.timers, (java.lang.Integer.class.getClassLoader()));
            instance.imageURL = ((String) in.readValue((String.class.getClassLoader())));
            instance.originalURL = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Recipe[] newArray(int size) {
            return (new Recipe[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * 
     * @param ingredients
     *     The ingredients
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * 
     * @return
     *     The steps
     */
    public List<String> getSteps() {
        return steps;
    }

    /**
     * 
     * @param steps
     *     The steps
     */
    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    /**
     * 
     * @return
     *     The timers
     */
    public List<Integer> getTimers() {
        return timers;
    }

    /**
     * 
     * @param timers
     *     The timers
     */
    public void setTimers(List<Integer> timers) {
        this.timers = timers;
    }

    /**
     * 
     * @return
     *     The imageURL
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * 
     * @param imageURL
     *     The imageURL
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * 
     * @return
     *     The originalURL
     */
    public String getOriginalURL() {
        return originalURL;
    }

    /**
     * 
     * @param originalURL
     *     The originalURL
     */
    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                ", timers=" + timers +
                ", imageURL='" + imageURL + '\'' +
                ", originalURL='" + originalURL + '\'' +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeList(ingredients);
        dest.writeList(steps);
        dest.writeList(timers);
        dest.writeValue(imageURL);
        dest.writeValue(originalURL);
    }

    public int describeContents() {
        return  0;
    }

}
