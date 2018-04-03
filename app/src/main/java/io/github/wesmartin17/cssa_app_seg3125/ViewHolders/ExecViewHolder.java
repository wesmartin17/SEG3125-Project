package io.github.wesmartin17.cssa_app_seg3125.ViewHolders;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class ExecViewHolder extends RecyclerView.ViewHolder{

    TextView mTitleText;
    TextView mDescriptionText;
    Button mButton;
    ImageView mImageView;

    public ExecViewHolder(View itemView) {
        super(itemView);
        mTitleText = (TextView)itemView.findViewById(R.id.titleText);
        mDescriptionText = (TextView)itemView.findViewById(R.id.descriptionText);
        mImageView = (ImageView)itemView.findViewById(R.id.imageView);
        mButton = (Button)itemView.findViewById(R.id.button);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"some@email.address"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Question about UPCOMINGEVENT");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                v.getContext().startActivity(Intent.createChooser(intent, ""));
            }
        });

    }

    public void setTitleText(String text){
        mTitleText.setText(text);
    }

    public void setDescriptionText(String text){
        mDescriptionText.setText(text);
    }

    public void setImgDrawable(Drawable d){
        //mImageView.setImageDrawable(d);

    }

}
