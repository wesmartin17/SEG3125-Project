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
                holder.setTitleText("Research at EECS");
                holder.setDescriptionText("Come see professors present their research!");
                holder.setDateText("January 2, 7:00PM");
                holder.setImgDrawable(context.getResources().getDrawable(R.drawable.research));
                break;
            case 1:
                holder.setTitleText("Friends Trivia at Mais");
                holder.setDescriptionText("Come out and play trivia.");
                holder.setDateText("January 20, 7:00PM");
                holder.setImgDrawable(context.getResources().getDrawable(R.drawable.trivia));
                break;
            case 2:
                holder.setTitleText("Loft Night");
                holder.setDescriptionText("Come play games at the loft, free food included.");
                holder.setDateText("January 22, 7:00PM");
                holder.setImgDrawable(context.getResources().getDrawable(R.drawable.loft));
                break;
            case 3:
                holder.setTitleText("Lightning talks");
                holder.setDateText("March 18, 7:00PM");
                holder.setDescriptionText("Come hear what people have to say about lightning.");
                holder.setImgDrawable(context.getResources().getDrawable(R.drawable.lightning));
                break;
            case 4:
                holder.setTitleText("Billiards @ Mclarens");
                holder.setDateText("March 30, 10:00PM");
                holder.setDescriptionText("Come hangout with Justyn at Junxion.");
                holder.setImgDrawable(context.getResources().getDrawable(R.drawable.billiards));
                break;
            case 5:
                holder.setTitleText("Movie Night");
                holder.setDateText("April 1, 7:00PM");
                holder.setDescriptionText("Come watch movies and raise money for CHEO");
                holder.setImgDrawable(context.getResources().getDrawable(R.drawable.movienight));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
