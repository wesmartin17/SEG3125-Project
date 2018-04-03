package io.github.wesmartin17.cssa_app_seg3125;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import io.github.wesmartin17.cssa_app_seg3125.Adapters.ArticleAdapter;
import io.github.wesmartin17.cssa_app_seg3125.Adapters.EventAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    int stack = 0;
    int page = 0;
    final static int MAX_PAGES = 2;

    RecyclerView mRecyclerView;
    Button newerButton;
    Button olderButton;

    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        newerButton = (Button) view.findViewById(R.id.newerButton);
        olderButton = (Button) view.findViewById(R.id.olderButton);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(new ArticleAdapter(getContext(),page));

        olderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(page < MAX_PAGES) {
                    page++;

                    mRecyclerView.removeAllViews();
                    mRecyclerView.setAdapter(new ArticleAdapter(getContext(),page));
                    if(stack == 0){
                        newerButton.setEnabled(true);
                        newerButton.setBackgroundResource(R.drawable.button_outline);
                    }
                    stack++;
                }
                if(page == MAX_PAGES){
                    olderButton.setEnabled(false);
                    olderButton.setBackgroundResource(R.drawable.button_disabled);
                }
            }
        });

        newerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page == MAX_PAGES){
                    olderButton.setEnabled(true);
                    olderButton.setBackgroundResource(R.drawable.button_outline);
                }
                page --;
                mRecyclerView.removeAllViews();
                mRecyclerView.setAdapter(new ArticleAdapter(getContext(),page));
                stack--;
                if(stack == 0){
                    newerButton.setEnabled(false);
                    newerButton.setBackgroundResource(R.drawable.button_disabled);
                }

            }
        });

        return view;
    }

}
