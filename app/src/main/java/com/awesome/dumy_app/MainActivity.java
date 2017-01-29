package com.awesome.dumy_app;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ProfileStore mProfile;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for custom data
        initProfileData();

        //initializing UI components
        initUi();
     }
    private void initUi(){
        TextView mProfileTextView = (TextView)findViewById(R.id.profile_name);
        TextView mLocationTextView = (TextView)findViewById(R.id.profile_location);
        ImageView mProfileImageView = (ImageView)findViewById(R.id.profile_picture);

        //linear buttons
        TextView mFollowerTextView = (TextView)findViewById(R.id.follower_textview);
        TextView mStoriesTextView = (TextView)findViewById(R.id.stories_textview);
        TextView mFollowingTextView = (TextView)findViewById(R.id.following_textview);
        //render profile info
        mProfileImageView.setBackgroundDrawable(getResources().getDrawable(mProfile.getProfileImage()));
        mProfileTextView.setText(mProfile.getProfileName());
        mLocationTextView.setText(mProfile.getLocation());
        mFollowerTextView.setText(Integer.toString(mProfile.getFollowers()));
        mStoriesTextView.setText(Integer.toString(mProfile.getStories()));
        mFollowingTextView.setText(Integer.toString(mProfile.getFollowing()));

        //toolbar
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.appTitle);
        //collapsingToolbar.setTitle("Profile");
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.transparent));

        // Change status bar color
        if(Build.VERSION.SDK_INT >=21)
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        RecyclerView profileAdapter = (RecyclerView) findViewById(R.id.recycler_view_profile);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, mProfile.getFeeds());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        profileAdapter.setLayoutManager(linearLayoutManager);
        profileAdapter.setNestedScrollingEnabled(false);
        profileAdapter.setAdapter(recyclerViewAdapter);
    }
    private void initProfileData() {
        //adding custom data for view
        mProfile = new ProfileStore(R.mipmap.jdpp, "Johnny Depp", "Punjab, India", 42, 517, 284);
        mProfile.appendFeed(new FeedStore(R.mipmap.jdpp, "My trip to Italy", "I just returned from Itly, I amnlkshjksajbn ksja  hljsk js us huk jhs hs gcks  us ks a u cjkhs kjh s"));
        mProfile.appendFeed(new FeedStore(R.mipmap.download, "My trip to Italy", "I just returned from Itly, I amnlkshjksajbn ksja  hljsk js us huk jhs hs gcks  us ks a u cjkhs kjh s"));
        mProfile.appendFeed(new FeedStore(R.mipmap.jdpp, "My trip to Italy", "I just returned from Itly, I amnlkshjksajbn ksja  hljsk js us huk jhs hs gcks  us ks a u cjkhs kjh s"));
        mProfile.appendFeed(new FeedStore(R.mipmap.download, "My trip to Italy", "I just returned from Itly, I amnlkshjksajbn ksja  hljsk js us huk jhs hs gcks  us ks a u cjkhs kjh s"));
        mProfile.appendFeed(new FeedStore(R.mipmap.download, "My trip to Italy", "I just returned from Itly, I amnlkshjksajbn ksja  hljsk js us huk jhs hs gcks  us ks a u cjkhs kjh s"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
 }
