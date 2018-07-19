
package br.gov.to.tce.exemplo10;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food {

    @SerializedName("item_name")
    @Expose
    private String foodName;
    @SerializedName("classification")
    @Expose
    private String classification;
    @SerializedName("image")
    @Expose
    private String image;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Food(String foodName, String classification, String image) {
        this.foodName = foodName;
        this.classification = classification;
        this.image = image;
    }

}
