package com.note.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends Activity implements ActionBar.TabListener{



    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                mViewPager=(ViewPager)findViewById(R.id.viewpager);

                final ActionBar actionBar=getActionBar();
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

                actionBar.addTab(actionBar.newTab()
                        .setText(R.string.tabLogIn)
                        .setTabListener(this));
                actionBar.addTab(actionBar.newTab()
                        .setText(R.string.tabRegistration)
                        .setTabListener(this));



        PagerAdapter pagerAdapter=new TabsPagerAdapter(getFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
                @Override
            public void onPageSelected(int position){
                getActionBar().setSelectedNavigationItem(position);
            }
        }
        );




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition(),true);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
