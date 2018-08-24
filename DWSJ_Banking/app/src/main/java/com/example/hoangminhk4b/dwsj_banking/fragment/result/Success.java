package com.example.hoangminhk4b.dwsj_banking.fragment.result;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hoangminhk4b.dwsj_banking.R;
import com.example.hoangminhk4b.dwsj_banking.base.BaseFragment;
import com.example.hoangminhk4b.dwsj_banking.fragment.transfer.MainTransfer;
import com.example.hoangminhk4b.dwsj_banking.models.SuccessModel;

public class Success extends BaseFragment implements View.OnClickListener {
    private TextView tvMaDT;
    private TextView tvMaKH;
    private TextView tvMaTKKH;
    private TextView tvMoney;
    private TextView tvPhi;
    private Button btnNext;
    private SuccessModel success;
    @Override
    protected int getLayout() {
        return R.layout.success;
    }

    @Override
    protected void initView(View view) {
        tvMaDT=view.findViewById(R.id.tvMaDT);
        tvMaKH=view.findViewById(R.id.tvMaKH);
        tvMaTKKH=view.findViewById(R.id.tvMaTKKH);
        tvMoney=view.findViewById(R.id.tvMoney);
        tvPhi=view.findViewById(R.id.tvPhi);
        btnNext=view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
    }

    @Override
    protected void init() {
        tvMaDT.setText(success.getTvMaDT());
        tvMaKH.setText(success.getTvMaKH());
        tvMaTKKH.setText(success.getTvMaTKKH());
        tvMoney.setText(success.getTvMoney());
        tvPhi.setText(success.getTvPhi());
    }

    public void setData(SuccessModel data){
        this.success=data;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNext:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flGiaoDich,new MainTransfer()).commit();
                break;
        }
    }
}
