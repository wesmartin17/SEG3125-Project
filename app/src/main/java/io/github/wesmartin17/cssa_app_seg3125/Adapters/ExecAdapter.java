package io.github.wesmartin17.cssa_app_seg3125.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.wesmartin17.cssa_app_seg3125.R;
import io.github.wesmartin17.cssa_app_seg3125.ViewHolders.ExecViewHolder;

/**
 * Created by WM on 2018-04-03.
 */

public class ExecAdapter extends RecyclerView.Adapter<ExecViewHolder> {

    public ExecAdapter(){
        super();
    }

    @Override
    public ExecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_exec_card,parent,false);

        return new ExecViewHolder(card);
    }

    @Override
    public void onBindViewHolder(ExecViewHolder holder, int position) {
        switch(position){
            case 0:
                holder.setTitleText("Hac Mayter");
                holder.setDescriptionText("Exec Affairs");
                break;
            case 1:
                holder.setTitleText("Deyna Roewald");
                holder.setDescriptionText("Internal");
                break;
            case 2:
                holder.setTitleText("Panita Opescu");
                holder.setDescriptionText("President");
                break;
            case 3:
                holder.setTitleText("Junxion Jlorendo");
                holder.setDescriptionText("Social");
                break;
            case 4:
                holder.setTitleText("Catteo Molombi");
                holder.setDescriptionText("Comms");
                break;
            case 5:
                holder.setTitleText("Piego Dontones");
                holder.setDescriptionText("Academic");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}