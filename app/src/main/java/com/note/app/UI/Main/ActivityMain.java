package com.note.app.UI.Main;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.note.app.AdapterTabsPager;
import com.note.app.R;

public class ActivityMain extends Activity implements ActionBar.TabListener {

	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mViewPager = (ViewPager) findViewById(R.id.viewpager);

		final ActionBar actionBar = getActionBar();
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		} else {
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

			actionBar.addTab(actionBar.newTab().setText(R.string.tabLogIn)
					.setTabListener(this));
			actionBar.addTab(actionBar.newTab()
					.setText(R.string.tabRegistration).setTabListener(this));

			mViewPager
					.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
						@Override
						public void onPageSelected(int position) {
							getActionBar().setSelectedNavigationItem(position);
						}
					});

		}

		PagerAdapter pagerAdapter = new AdapterTabsPager(getFragmentManager(),
				getResources().getConfiguration().orientation);
		mViewPager.setAdapter(pagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		mViewPager.setCurrentItem(tab.getPosition(), true);

	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {

	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {

	}
}
