package com.example.hoangminhk4b.dwsj_banking.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null) {
            view=inflater.inflate(getLayout(), container,false);
            initView(view);
        }
        init();
        return view;
    }

    protected void init() {
    }

    protected abstract int getLayout();
    protected abstract void initView(View view);

}
