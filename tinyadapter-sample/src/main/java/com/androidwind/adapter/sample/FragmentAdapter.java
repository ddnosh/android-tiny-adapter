package com.androidwind.adapter.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    //private List<Fragment> mFragment;
    private Fragment singleFragment;
    private Fragment multipleFragment;

    public FragmentAdapter(int type, FragmentManager fm) {
        super(fm);
        if (type == 0) {
            singleFragment = new NewSingleFragment();
            multipleFragment = new NewMultipleFragment();
        } else if (type == 1) {
            singleFragment = new OldSingleFragment();
            multipleFragment = new OldMultipleFragment();
        }
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = singleFragment;
                break;
            case 1:
                fragment = multipleFragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
