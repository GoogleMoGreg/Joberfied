package com.chrs.iit.android.greg.joberfied;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by greg on 8/7/16.
 */
public class ViewPageAdapterEmployer extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments=new ArrayList<>();

    public void addFragments(Fragment fragment){
        this.fragments.add(fragment);
    }

    public ViewPageAdapterEmployer(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
