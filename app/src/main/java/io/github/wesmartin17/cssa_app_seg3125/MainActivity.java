package io.github.wesmartin17.cssa_app_seg3125;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("CSSA/AEI");
        getSupportActionBar().setLogo(R.drawable.main_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        mFragmentManager = getSupportFragmentManager();
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout)findViewById(R.id.tabLayout);
        mTabLayout.setTabTextColors(
                Color.WHITE,
                Color.WHITE);

        final String[] labels = {"EVENTS","HOME","EXEC"};

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setText(labels[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setText("");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.setAdapter(new FragmentPagerAdapter(mFragmentManager) {
            @Override
            public Fragment getItem(int position) {
                switch(position){
                    case 0:
                        return new FragmentEvents();
                    case 1:
                        return new FragmentHome();
                    case 2:
                        return new FragmentInfo();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        mTabLayout.getTabAt(0).setIcon(R.drawable.event);
        mTabLayout.getTabAt(1).setIcon(R.drawable.cal);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_perm_contact_calendar);
        mViewPager.setCurrentItem(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean b = super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return b;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent;
        switch (item.getItemId()) {
            case R.id.action_settings:
                myIntent = new Intent(MainActivity.this, SettingsActivity.class);

                MainActivity.this.startActivity(myIntent);
                return true;
            case R.id.action_help:
                myIntent = new Intent(MainActivity.this, HelpActivity.class);
                MainActivity.this.startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
