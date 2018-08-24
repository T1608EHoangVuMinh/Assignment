package com.example.hoangminhk4b.dwsj_banking.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.example.hoangminhk4b.dwsj_banking.base.BasePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class InitMainAdapter extends FragmentPagerAdapter {
    List<Fragment> listFragment = new ArrayList<>();
    List<String> listTilte = new ArrayList<>();

    public InitMainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return listFragment.get(i);
    }

    public void addFragmentPager(Fragment fragment, String title) {
        this.listFragment.add(fragment);
        this.listTilte.add(title);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTilte.get(position);
    }
}
