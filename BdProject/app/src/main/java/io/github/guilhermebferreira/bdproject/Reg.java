package io.github.guilhermebferreira.bdproject;

public class Reg {

    private int _id;
    private String name;
    private String imagepath;
    private float rating;


    public Reg(String name, String imagepath, float rating) {
        this(0,name,imagepath,rating);
    }

    public Reg(int _id, String name, String imagepath, float rating) {
        this._id = _id;
        this.name = name;
        this.imagepath = imagepath;
        this.rating = rating;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
