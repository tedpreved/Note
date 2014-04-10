package com.note.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v13.app.FragmentPagerAdapter;


/**
 * Created by Home on 3/29/14.
 */
public class AdapterTabsPager extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private final int mOrient;

    public AdapterTabsPager(FragmentManager fm, int Orient){
        super(fm);       
        mOrient=Orient;
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
    
    @Override
    public float getPageWidth(int position) {
    	
    	if(mOrient==Configuration.ORIENTATION_LANDSCAPE){
    		return(0.5f);
    	}
    	else {
    		return (1.0f);       
    		}
    }
    
}
