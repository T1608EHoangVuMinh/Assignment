package com.example.hoangminhk4b.dwsj_banking.fragment.transfer;

import android.view.View;

import com.example.hoangminhk4b.dwsj_banking.R;
import com.example.hoangminhk4b.dwsj_banking.base.BaseFragment;

public class Transfer extends BaseFragment {
    private MainTransfer mainTransfer;

    @Override
    protected int getLayout() {
        return R.layout.giaodich;
    }

    @Override
    protected void initView(View view) {
        mainTransfer=new MainTransfer();

    }

    @Override
    protected void init() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flGiaoDich,mainTransfer).commit();
    }

    public MainTransfer getMainTransfer() {
        return mainTransfer;
    }
}
