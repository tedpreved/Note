package com.note.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Home on 3/29/14.
 */
public class AdapterTabsPager extends FragmentPagerAdapter{

    private List<Fragment> fragments;

    public AdapterTabsPager(FragmentManager fm){
        super(fm);
        this.fragments=new ArrayList<Fragment>();
        fragments.add(new Fragment_Login());
        fragments.add(new Fragment_Registration());

    };

    @Override
    public Fragment getItem(int position){

        return fragments.get(position);
        }

    @Override
    public int getCount(){

        return fragments.size();
    }
}
