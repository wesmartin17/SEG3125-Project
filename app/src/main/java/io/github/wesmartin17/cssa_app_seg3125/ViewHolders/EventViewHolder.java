package io.github.wesmartin17.cssa_app_seg3125.ViewHolders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.wesmartin17.cssa_app_seg3125.FragmentViewEvent;
import io.github.wesmartin17.cssa_app_seg3125.R;
import io.github.wesmartin17.cssa_app_seg3125.FragmentEvents;

/**
 * Created by WM on 2018-03-30.
 */

public class EventViewHolder extends RecyclerView.ViewHolder {

    TextView mTitleText;
    TextView mDescriptionText;
    TextView mDateText;
    Button mButton;
    ImageView mImageView;
    Context c;
    View v;
    public EventViewHolder(View itemView) {
        super(itemView);
        mTitleText = (TextView)itemView.findViewById(R.id.titleText);
        mDescriptionText = (TextView)itemView.findViewById(R.id.descriptionText);
        mImageView = (ImageView)itemView.findViewById(R.id.imageView);
        mDateText = (TextView)itemView.findViewById(R.id.dateText);
        mButton = (Button)itemView.findViewById(R.id.viewEventButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentEvents.replaceFragment(new FragmentViewEvent(),true);
            }
        });
        c = itemView.getContext();
        v = itemView;
    }

    public void setTitleText(String text){
        mTitleText.setText(text);
    }

    public void setDescriptionText(String text){
        mDescriptionText.setText(text);
    }

    public void setImgDrawable(Drawable d){
        mImageView.setImageDrawable(d);

    }

    public void setDateText(String text){
        mDateText.setText(text);
    }

}
