package com.example.hoangminhk4b.dwsj_banking.base;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BasePagerAdapter<T> extends PagerAdapter {
    protected Activity activity;
    protected List<T> data;
    View view;

    public BasePagerAdapter(Activity activity, List<T> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(activity).inflate(getLayout(),container,false);
        initView(view,position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(view);
    }

    public abstract int getLayout();
    protected abstract void initView(View view,int position);
}
