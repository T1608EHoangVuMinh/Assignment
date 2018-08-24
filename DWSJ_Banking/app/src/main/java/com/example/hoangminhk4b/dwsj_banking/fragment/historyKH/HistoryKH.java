package com.example.hoangminhk4b.dwsj_banking.fragment.historyKH;

import android.view.View;

import com.example.hoangminhk4b.dwsj_banking.R;
import com.example.hoangminhk4b.dwsj_banking.base.BaseFragment;

public class HistoryKH extends BaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.history_kh;
    }

    @Override
    protected void initView(View view) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flHistoryKH,new MainHistoryKH()).commit();
    }
}
