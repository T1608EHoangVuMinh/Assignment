package com.example.hoangminhk4b.dwsj_banking.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.hoangminhk4b.dwsj_banking.R;
import com.example.hoangminhk4b.dwsj_banking.adapter.InitMainAdapter;
import com.example.hoangminhk4b.dwsj_banking.base.BaseFragment;
import com.example.hoangminhk4b.dwsj_banking.fragment.historyDT.HistoryDT;
import com.example.hoangminhk4b.dwsj_banking.fragment.historyKH.HistoryKH;
import com.example.hoangminhk4b.dwsj_banking.fragment.transfer.Transfer;

public class InitMain extends BaseFragment {
    private ViewPager vpMain;
    private TabLayout tlMain;
    @Override
    protected int getLayout() {
        return R.layout.init_main;
    }

    @Override
    protected void initView(View view) {
        vpMain=view.findViewById(R.id.vpMain);
        tlMain=view.findViewById(R.id.tlMain);

        InitMainAdapter initMainAdapter=new InitMainAdapter(getActivity().getSupportFragmentManager());
        initMainAdapter.addFragmentPager(new Transfer(),"Chuyển tiền");
        initMainAdapter.addFragmentPager(new HistoryDT(),"Đối tác");
        initMainAdapter.addFragmentPager(new HistoryKH(),"Khách hàng");
        vpMain.setAdapter(initMainAdapter);
        tlMain.setupWithViewPager(vpMain);
    }
}
