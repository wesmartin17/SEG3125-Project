package io.github.wesmartin17.cssa_app_seg3125.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.wesmartin17.cssa_app_seg3125.R;
import io.github.wesmartin17.cssa_app_seg3125.ViewHolders.ArticleViewHolder;

/**
 * Created by WM on 2018-04-03.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    Context context;
    int page;

    public ArticleAdapter(Context context, int page){
        super();
        this.context = context;
        this.page = page;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_article_card,parent,false);

        return new ArticleViewHolder(card);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {

        switch (position){
            case 0:
                holder.setTitleText("Elections Today!!");
                holder.setDateText("March 28th, 2018");
                holder.setDescriptionText("Come and vote for next years executives of the CSSA!");
                break;
            case 1:
                holder.setTitleText("Reading Week");
                holder.setDateText("February 18th-22nd, 2018");
                holder.setDescriptionText("Enjoy the week off, dont forget to study!");
                break;
            case 2:
                holder.setTitleText("Looking for a Chief of Elections Officer");
                holder.setDateText("February 15th, 2018");
                holder.setDescriptionText("Come to our office in SITE 4076 to apply, thanks for your help!");
                break;
            case 3:
                holder.setTitleText("UOttaHack");
                holder.setDateText("February 12th, 2018");
                holder.setDescriptionText("Goodluck to everyone attending the hackathon this weekend!");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}