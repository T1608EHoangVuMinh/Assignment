package com.example.hoangminhk4b.dwsj_banking.fragment.transfer;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoangminhk4b.dwsj_banking.R;
import com.example.hoangminhk4b.dwsj_banking.Utils.Constant;
import com.example.hoangminhk4b.dwsj_banking.Utils.utils;
import com.example.hoangminhk4b.dwsj_banking.base.BaseFragment;
import com.example.hoangminhk4b.dwsj_banking.dataSource.APITransfer;
import com.example.hoangminhk4b.dwsj_banking.fragment.result.Success;
import com.example.hoangminhk4b.dwsj_banking.models.FormService;
import com.example.hoangminhk4b.dwsj_banking.models.SuccessModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainTransfer extends BaseFragment implements View.OnClickListener{
    private EditText etMaDT;
    private EditText etMKDT;
    private EditText etMaKH;
    private EditText etMaTK;
    private EditText etMaPin;
    private EditText etMoney;
    private Button btnTransfer;
    private Button btnReset;
    private Success success;
    @Override
    protected int getLayout() {
        return R.layout.main_giaodich;
    }

    @Override
    protected void initView(View view) {
        etMaDT=view.findViewById(R.id.etMaDT);
        etMKDT=view.findViewById(R.id.etMKDT);
        etMaKH=view.findViewById(R.id.etMaKH);
        etMaTK=view.findViewById(R.id.etMaTK);
        etMaPin=view.findViewById(R.id.etMaPIN);
        etMoney=view.findViewById(R.id.etMoney);
        btnTransfer=view.findViewById(R.id.btnTransfer);
        btnReset=view.findViewById(R.id.btnReset);
        view.findViewById(R.id.tvBanner).setSelected(true);

        btnReset.setOnClickListener(this);
        btnTransfer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTransfer:
                setTransfer();
                break;
            case R.id.btnReset:
                etMaDT.setText("");
                etMKDT.setText("");
                etMaKH.setText("");
                etMaTK.setText("");
                etMaPin.setText("");
                etMoney.setText("");
                break;
        }
    }
    private void setTransfer(){
        //fix error: Use JsonReader.setLenient(true) to accept malformed JSON
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit=new Retrofit.Builder().baseUrl(APITransfer.URL_BASE)
                .addConverterFactory(ScalarsConverterFactory.create()) //fix error:JSON document was not fully consumed.
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        APITransfer service=retrofit.create(APITransfer.class);
        if(checkEmpty(etMaDT,"Mã đối tác không được để trống")) return;
        if(checkEmpty(etMKDT,"Mật khẩu đối tác không được để trống"))return;
        if(checkEmpty(etMaKH,"Mã khác hàng không được để trống"))return;
        if(checkEmpty(etMaTK,"Mã số tài khoản không được để trống"))return;
        if(checkEmpty(etMaPin,"Mã PIN không được để trống"))return;
        if(checkEmpty(etMoney,"Số tiền chuyển không được để trống"))return;

        btnTransfer.setClickable(false);
        FormService formService=new FormService(
                etMaDT.getText().toString(),
                etMKDT.getText().toString(),
                etMaKH.getText().toString(),
                etMaTK.getText().toString(),
                Integer.parseInt(etMaPin.getText().toString()),
                Integer.parseInt(etMoney.getText().toString()));
        service.sendFormToService(formService).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String msg=response.body();
                btnTransfer.setClickable(true);
                Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
                if(msg.equals(Constant.GIAO_DICH_THANH_CONG)){
                    if(success==null){
                        success=new Success();
                    }
                    int PhiGD= utils.phiGD(etMoney.getText().toString());
                    SuccessModel successModel=new SuccessModel(
                            etMaDT.getText().toString(),
                            etMaKH.getText().toString(),
                            etMaTK.getText().toString(),
                            etMoney.getText().toString(),
                            String.valueOf(PhiGD)
                    );
                    success.setData(successModel);
                    getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.flGiaoDich,success ).commit();
                };
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getActivity(),"Kiểm tra lại mang",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean checkEmpty(EditText ed,String title){
        if(ed.getText().toString().isEmpty()){
            Toast.makeText(getContext(),title,Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    @Override
    public void onResume() {
        etMaDT.setText("");
        etMKDT.setText("");
        etMaKH.setText("");
        etMaTK.setText("");
        etMaPin.setText("");
        etMoney.setText("");
        super.onResume();
    }
}
