package com.example.hoangminhk4b.dwsj_banking.fragment.historyDT;

import android.view.View;

import com.example.hoangminhk4b.dwsj_banking.R;
import com.example.hoangminhk4b.dwsj_banking.base.BaseFragment;

public class HistoryDT extends BaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.history_dt;
    }

    @Override
    protected void initView(View view) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flHistoryDT,new MainHistoryDT()).commit();
    }
}
