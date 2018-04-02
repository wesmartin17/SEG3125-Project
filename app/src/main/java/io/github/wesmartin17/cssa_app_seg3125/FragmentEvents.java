package io.github.wesmartin17.cssa_app_seg3125;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEvents extends Fragment {

    private static FragmentManager mFragmentManager;
    private static FragmentTransaction mFragmentTransition;

    public FragmentEvents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        mFragmentManager = getFragmentManager();
        mFragmentTransition = mFragmentManager.beginTransaction();
        mFragmentTransition.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left,android.R.anim.slide_in_left,R.anim.slide_out_right);
        mFragmentTransition.replace(R.id.frameeee,new FragmentListOfEvents());
        mFragmentTransition.addToBackStack(null);
        //mFragmentManager.beginTransaction().add(new FragmentEvents(),"EVENTS").commit();
        mFragmentTransition.commit();

        return view;
    }



    /**
     * Replaces a given fragment in the fragment frame. should probably go somewhere else eventually where it can be more widely used
     *
     * @param fragment desired fragment within the scope of this class (it must implement its OnFragmentIneractionListener)
     * @param backStack it will add it to the backstack if true
     */
    static public void replaceFragment(Fragment fragment, boolean backStack) {
        mFragmentTransition = mFragmentManager.beginTransaction();
        mFragmentTransition.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left,android.R.anim.slide_in_left,R.anim.slide_out_right);

        if(backStack)
            mFragmentTransition.replace(R.id.frameeee,fragment).addToBackStack("").commit();
        else
            mFragmentTransition.replace(R.id.viewPager,fragment).commit();
    }


}
