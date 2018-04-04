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

import static android.view.View.GONE;

/**
 * Created by WM on 2018-04-03.
 */

public class ArticleViewHolder  extends RecyclerView.ViewHolder{

    TextView mTitleText;
    TextView mDescriptionText;
    TextView mDateText;
    TextView mLocationText;
    TextView showAll;
    Button mButton;
    //ImageView mImageView;

    public ArticleViewHolder(View itemView) {
        super(itemView);
        mTitleText = (TextView)itemView.findViewById(R.id.titleText);
        mDescriptionText = (TextView)itemView.findViewById(R.id.detail_description_content);
        //mImageView = (ImageView)itemView.findViewById(R.id.imageView);
        mDateText = (TextView)itemView.findViewById(R.id.dateText);
        mLocationText = (TextView)itemView.findViewById(R.id.locationText);
        showAll = (TextView)itemView.findViewById(R.id.detail_read_all);

        showAll = (TextView)itemView.findViewById(R.id.detail_read_all);



        showAll.setOnClickListener(new View.OnClickListener() {
            boolean expanded = false;

            @Override
            public void onClick(View v) {
                if(!expanded) {
                    showAll.setText("▲");

                    mDescriptionText.setMaxLines(Integer.MAX_VALUE);
                    expanded = true;
                }
                else{
                    showAll.setText("▼");

                    mDescriptionText.setMaxLines(5);
                    expanded = false;
                }
            }
        });


    }

    public void setTitleText(String text){
        mTitleText.setText(text);
    }

    public void setDescriptionText(String text){
        mDescriptionText.setText(text);
        if(mDescriptionText.getLineCount() <=2){
            showAll.setVisibility(GONE);
        }
    }

    public void setImgDrawable(Drawable d){
        //mImageView.setImageDrawable(d);

    }

    public void setDateText(String text){
        mDateText.setText(text);
    }

}
