package io.github.wesmartin17.cssa_app_seg3125;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewEvent extends Fragment {

    boolean favourited = false;

    Toolbar toolbar;
    Button fbButton;

    TextView mTitleText;
    TextView mLocationText;
    TextView mDateText;
    TextView mDescriptionText;
    ImageView mImageView;

    Bundle bundle;

    public FragmentViewEvent() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            this.bundle = bundle;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_event, container, false);

        mTitleText = (TextView)view.findViewById(R.id.titleText);
        mDateText = (TextView)view.findViewById(R.id.dateText);
        mLocationText = (TextView)view.findViewById(R.id.locationText);
        mDescriptionText = (TextView)view.findViewById(R.id.detail_description_content);
        mImageView = (ImageView)view.findViewById(R.id.imageView);

        if(bundle!=null) {
            mTitleText.setText(bundle.getString("TITLE"));
            mDateText.setText(bundle.getString("DATE"));
            mLocationText.setText(bundle.getString("LOCATION"));
            mDescriptionText.setText(bundle.getString("DESCRIPTION"));

            mImageView.setImageBitmap((Bitmap)bundle.getParcelable("IMAGE"));
        }
        else{
            Log.v("CssA","bundle null boi");
        }
        fbButton = (Button)view.findViewById(R.id.fbButton);
        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        toolbar.inflateMenu(R.menu.event_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getOrder()) {
                    //favourite pressed
                    case 0:
                        if(!favourited) {
                            favourited = true;
                            item.setIcon(R.drawable.ic_star);
                            Toast.makeText(getContext(), "Following event. You will receive a reminder and notifications for any changes to the event details", Toast.LENGTH_LONG).show();
                        }
                        else{
                            favourited = false;
                            item.setIcon(R.drawable.ic_star_border);
                            Toast.makeText(getContext(), "Event unfollowed", Toast.LENGTH_LONG).show();

                        }
                        return true;
                    //contact organizer pressed
                    case 1:
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("plain/text");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"some@email.address"});
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Question about UPCOMINGEVENT");
                        intent.putExtra(Intent.EXTRA_TEXT, "");
                        startActivity(Intent.createChooser(intent, ""));
                        return true;
                }
                return false;
            }
        });

        final TextView showAll = (TextView) view.findViewById(R.id.detail_read_all);
        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAll.setVisibility(View.INVISIBLE);

                mDescriptionText.setMaxLines(Integer.MAX_VALUE);
            }
        });

        fbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFacebookIntent(getContext().getPackageManager(),"https://www.facebook.com/CSSAAEI");
            }
        });

        return view;
    }

    /**
     * <p>Intent to open the official Facebook app. If the Facebook app is not installed then the
     * default web browser will be used.</p>
     *
     * <p>Example usage:</p>
     *
     * {@code newFacebookIntent(ctx.getPackageManager(), "https://www.facebook.com/JRummyApps");}
     *
     * @param pm
     *     The {@link PackageManager}. You can find this class through {@link
     *     Context#getPackageManager()}.
     * @param url
     *     The full URL to the Facebook page or profile.
     * @return An intent that will open the Facebook page/profile.
     */
    public  Intent newFacebookIntent(PackageManager pm, String url) {
        Uri uri = Uri.parse(url);
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                // http://stackoverflow.com/a/24547437/1048340
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
            else{
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(url));
                Intent chooserIntent = Intent.createChooser(browserIntent, "dialog title");
                startActivity(chooserIntent);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }

}
