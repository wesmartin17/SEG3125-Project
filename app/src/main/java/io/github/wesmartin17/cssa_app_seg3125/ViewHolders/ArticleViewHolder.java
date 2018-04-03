package io.github.wesmartin17.cssa_app_seg3125.ViewHolders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.wesmartin17.cssa_app_seg3125.FragmentEvents;
import io.github.wesmartin17.cssa_app_seg3125.FragmentViewEvent;
import io.github.wesmartin17.cssa_app_seg3125.R;

/**
 * Created by WM on 2018-04-03.
 */

public class ArticleViewHolder  extends RecyclerView.ViewHolder{

    TextView mTitleText;
    TextView mDescriptionText;
    TextView mDateText;
    TextView mLocationText;
    Button mButton;
    ImageView mImageView;

    public ArticleViewHolder(View itemView) {
        super(itemView);
        mTitleText = (TextView)itemView.findViewById(R.id.titleText);
        mDescriptionText = (TextView)itemView.findViewById(R.id.linerLayout);
        mImageView = (ImageView)itemView.findViewById(R.id.imageView);
        mDateText = (TextView)itemView.findViewById(R.id.dateText);
        mLocationText = (TextView)itemView.findViewById(R.id.locationText);
        mButton = (Button)itemView.findViewById(R.id.viewEventButton);
        /*mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentViewEvent f = new FragmentViewEvent();
                bundle.putString("TITLE",mTitleText.getText().toString());
                bundle.putString("DESCRIPTION",mDescriptionText.getText().toString());
                bundle.putString("DATE",mDateText.getText().toString());
                bundle.putString("LOCATION",mLocationText.getText().toString());
                //bundle.putInt("IMAGE",mImageView.getDrawable().get);

                f.setArguments(bundle);
                FragmentEvents.replaceFragment(f,true);
            }
        });*/

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
