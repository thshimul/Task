package com.example.task.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.task.ui.fragment.HomeFragment;
import com.example.task.ui.fragment.InboxFragment;
import com.example.task.ui.fragment.MoreFragment;

public class PageAdapter extends FragmentPagerAdapter {
    private int numOfTabs;
    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm,numOfTabs);
       this.numOfTabs=numOfTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0 :
                return new HomeFragment();
            case 1 :
                return new InboxFragment();
            case 2 :
                return new MoreFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
