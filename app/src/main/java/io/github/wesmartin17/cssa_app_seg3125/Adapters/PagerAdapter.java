package io.github.wesmartin17.cssa_app_seg3125.Adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by WM on 2018-03-30.
 */


//
//THIS IS NOT ACTUALLY USED RIGHT NOW BUT COULD BE IN THE FUTURE. GO AWAY
//
public class PagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Fragment pageOne;
    Fragment pageTwo;
    Fragment pageThree;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
