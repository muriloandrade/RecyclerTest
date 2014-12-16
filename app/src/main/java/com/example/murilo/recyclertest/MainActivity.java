package com.example.murilo.recyclertest;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.common.view.SlidingTabLayout;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {

    private Toolbar mToolbar;
    private SlidingTabLayout mSlidingTabs;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mToolbar.setTitleTextColor(Color.WHITE);
        mSlidingTabs = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        mSlidingTabs.setViewPager(mViewPager);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        if (mViewPager != null)
        {
            mViewPager.setCurrentItem(tab.getPosition());
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {

        private ArrayList<String> mData = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);

            // Strings to 5 pages
            for (int i = 0; i < 5; i ++)
            {
                String title = "Page " + String.valueOf(i);
                mData.add(title);
            }
        }

        @Override
        public Fragment getItem(int i)
        {
            Fragment fragment;

            fragment = new PageFragment();

            return fragment;
        }


        @Override
        public int getCount()
        {
            return mData.size();
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return mData.get(position);
        }
    }


}


