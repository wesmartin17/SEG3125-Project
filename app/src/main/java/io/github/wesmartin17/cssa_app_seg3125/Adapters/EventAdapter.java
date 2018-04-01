package io.github.wesmartin17.cssa_app_seg3125.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.wesmartin17.cssa_app_seg3125.R;
import io.github.wesmartin17.cssa_app_seg3125.ViewHolders.EventViewHolder;

/**
 * Created by WM on 2018-03-31.
 */

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    Context context;

    public EventAdapter(Context context){
        super();
        this.context = context;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_event_card,parent,false);

        return new EventViewHolder(card);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

        switch(position){
            case 0:
                holder.setTitleText("Billiards Night @ Mclarens");
                holder.setDescriptionText("Come out and shoot some billiards with some friends and muck some food");

                //SOMEONE FIGURE THIS SHIT OUT THIS IS MY LEAST FAVOURITE THING ABOUT ANDROID ITS BULLSHIT
                holder.setImgDrawable(context.getResources().getDrawable(R.drawable.billiards));
                break;
            case 1:
                holder.setTitleText("Lightning talks");
                holder.setDescriptionText("Come hear what people have to say about lightning.");
                holder.setImgDrawable(context.getResources().getDrawable(R.drawable.lightning));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
