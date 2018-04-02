package io.github.wesmartin17.cssa_app_seg3125;


import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import io.github.wesmartin17.cssa_app_seg3125.Adapters.EventAdapter;
import io.github.wesmartin17.cssa_app_seg3125.ViewHolders.EventViewHolder;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEvents extends Fragment {

    RecyclerView mRecyclerView;

    public FragmentEvents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);



        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new EventAdapter(getContext()));
        layoutManager.scrollToPosition(4);


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean old = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.v("CSSA",""+layoutManager.findFirstVisibleItemPosition());
                if(layoutManager.findFirstVisibleItemPosition() < 4 && !old){
                    old = true;
                    //Toast.makeText(getContext(),"Showing past events",Toast.LENGTH_SHORT).show();
                    Snackbar.make(recyclerView,"Showing past events",Snackbar.LENGTH_SHORT).show();
                }
                else if(layoutManager.findFirstVisibleItemPosition() >=4 && old){
                    old = false;
                    Snackbar.make(recyclerView,"Showing upcoming events",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
