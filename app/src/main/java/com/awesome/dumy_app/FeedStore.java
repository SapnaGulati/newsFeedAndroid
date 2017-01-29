package com.awesome.dumy_app;

/**
 * Created by Himanshu on 29-01-2017.
 */

public class FeedStore {
    private String title, description;
    private int image;

    FeedStore(int image,String title,String description){
        this.image=image;
        this.title=title;
        this.description=description;
    }
    public int getImage() {
        return image;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}
