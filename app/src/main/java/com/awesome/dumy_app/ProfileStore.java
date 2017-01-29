package com.awesome.dumy_app;

import java.util.ArrayList;

/**
 * Created by Himanshu on 29-01-2017.
 */

public class ProfileStore {
    private String profileName,location;
    private int profileImage;
    private int stories,followers,following;
    private ArrayList<FeedStore> feeds;
    ProfileStore(int profileImage,String profileName,String location,int stories,int followers,int following){
        this.profileImage=profileImage;
        this.profileName=profileName;
        this.location=location;
        this.stories=stories;
        this.followers=followers;
        this.following=following;
        this.feeds =new ArrayList<FeedStore>();
    }

    public ArrayList<FeedStore> getFeeds() {
        return feeds;
    }

    public void setFeeds(ArrayList<FeedStore> feeds) {
        this.feeds = feeds;
    }

    public void appendFeed(FeedStore feed) {
        this.feeds.add(feed);
    }

    public String getProfileName() {
        return profileName;
    }

    public String getLocation() {
        return location;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public int getStories() {
        return stories;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }
}
