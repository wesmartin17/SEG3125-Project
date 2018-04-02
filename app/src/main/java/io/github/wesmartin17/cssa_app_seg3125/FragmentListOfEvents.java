package io.github.wesmartin17.cssa_app_seg3125;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import io.github.wesmartin17.cssa_app_seg3125.Adapters.EventAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListOfEvents extends Fragment {

    RecyclerView mRecyclerView;

    public FragmentListOfEvents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_of_events, container, false);



        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new EventAdapter(getContext()));
        layoutManager.scrollToPosition(3);

        FrameLayout f = (FrameLayout)view.findViewById(R.id.framee);

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
                if(layoutManager.findFirstCompletelyVisibleItemPosition() < 3 && !old){
                    old = true;
                    //Toast.makeText(getContext(),"Showing past events",Toast.LENGTH_SHORT).show();
                    Snackbar.make(recyclerView,"Showing past events",Snackbar.LENGTH_SHORT).show();
                }
                else if(layoutManager.findFirstVisibleItemPosition() >=3 && old){
                    old = false;
                    Snackbar.make(recyclerView,"Showing upcoming events",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
