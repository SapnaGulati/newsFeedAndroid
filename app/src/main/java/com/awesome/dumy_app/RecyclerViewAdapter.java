package com.awesome.dumy_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Himanshu on 29-01-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<FeedStore> mFeeds;
    RecyclerViewAdapter(Context context, ArrayList<FeedStore> mFeeds) {
        this.mContext = context;
        this.mFeeds = mFeeds;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.news_list_item, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mFeeds.get(position).getTitle());
        holder.description.setText(mFeeds.get(position).getDescription());
        holder.mImage.setImageDrawable(mContext.getResources().getDrawable(mFeeds.get(position).getImage()));
   }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemCount() {
        return mFeeds.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, description;
        private ImageView mImage;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
            mImage = (ImageView)itemView.findViewById(R.id.imageview_profile);
        }
    }
}
