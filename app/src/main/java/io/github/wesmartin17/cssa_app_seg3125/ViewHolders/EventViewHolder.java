package io.github.wesmartin17.cssa_app_seg3125.ViewHolders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
    TextView mLocationText;
    Button mButton;
    ImageView mImageView;
    Context c;
    View v;
    public EventViewHolder(View itemView) {
        super(itemView);
        mTitleText = (TextView)itemView.findViewById(R.id.titleText);
        mDescriptionText = (TextView)itemView.findViewById(R.id.linerLayout);
        mImageView = (ImageView)itemView.findViewById(R.id.imageView);
        mDateText = (TextView)itemView.findViewById(R.id.dateText);
        mLocationText = (TextView)itemView.findViewById(R.id.locationText);
        mButton = (Button)itemView.findViewById(R.id.viewEventButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentViewEvent f = new FragmentViewEvent();
                bundle.putString("TITLE",mTitleText.getText().toString());
                bundle.putString("DESCRIPTION",mDescriptionText.getText().toString());
                bundle.putString("DATE",mDateText.getText().toString());
                bundle.putString("LOCATION",mLocationText.getText().toString());

                //bundle.putInt("IMAGE",mImageView.getDrawable().get);
                mImageView.setDrawingCacheEnabled(true);
                bundle.putParcelable("IMAGE",mImageView.getDrawingCache());


                f.setArguments(bundle);
                FragmentEvents.replaceFragment(f,true);
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
