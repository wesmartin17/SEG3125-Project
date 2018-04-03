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

        holder.setDateText("January "+(((getItemCount()-position)+1) + (10*(2-page)))+" 2018");
/*        if(page == 1) {

        }
        else if(page == 2){
            switch(position){

            }
        }*/
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}