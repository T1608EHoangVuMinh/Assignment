package com.example.hoangminhk4b.dwsj_banking.fragment.historyKH;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoangminhk4b.dwsj_banking.R;
import com.example.hoangminhk4b.dwsj_banking.Utils.utils;
import com.example.hoangminhk4b.dwsj_banking.adapter.HistoryAdapter;
import com.example.hoangminhk4b.dwsj_banking.base.BaseFragment;
import com.example.hoangminhk4b.dwsj_banking.dataSource.APIHistory;
import com.example.hoangminhk4b.dwsj_banking.models.ResultHistoryModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainHistoryKH extends BaseFragment {
    private EditText etMaTKKH;
    private EditText etMaPin;
    private TextView etDateStart;
    private TextView etDateEnd;
    private Button btnCheck;
    private ListView lvHistory;

    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    @Override
    protected int getLayout() {
        return R.layout.main_history_kh;
    }

    @Override
    protected void initView(View view) {
        etMaTKKH=view.findViewById(R.id.etMaKH);
        etMaPin=view.findViewById(R.id.etMaPIN);
        etDateStart=view.findViewById(R.id.etDateStart);
        etDateEnd=view.findViewById(R.id.etDateEnd);
        btnCheck=view.findViewById(R.id.btnCheck);
        lvHistory=view.findViewById(R.id.lvHistory);

        etDateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDateSetListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int m=month+1;
                        etDateStart.setText(dayOfMonth+"/"+m+"/"+year);
                    }
                };
                setDatePicker(mOnDateSetListener);
            }
        });

        etDateEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDateSetListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int m=month+1;
                        etDateEnd.setText(dayOfMonth+"/"+m+"/"+year);
                    }
                };
                setDatePicker(mOnDateSetListener);
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder().baseUrl(APIHistory.URL_BASE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                APIHistory service=retrofit.create(APIHistory.class);

                if(checkEditTextEmpty(etMaTKKH,"Mã số tài khoản không được để trống")) return;
                if(checkEditTextEmpty(etMaPin,"Mã Pin không được để trống")) return;
                if(checkTextViewEmpty(etDateStart,"Ngày bắt đầu không để trống")) return;
                if(checkTextViewEmpty(etDateEnd,"Ngày kết thúc không để trống")) return;
                btnCheck.setClickable(false);

                int timeStart= utils.convertDateToTimestamp(etDateStart.getText().toString());
                int timeEnd=utils.convertDateToTimestamp(etDateEnd.getText().toString());

                Map<String,Object> body=new HashMap<>();
                body.put("username",etMaTKKH.getText().toString());
                body.put("password",etMaPin.getText().toString());
                body.put("timeStart",timeStart);
                body.put("timeEnd",timeEnd);
                service.getHistory(body).enqueue(new Callback<List<ResultHistoryModel>>() {
                    @Override
                    public void onResponse(Call<List<ResultHistoryModel>> call, Response<List<ResultHistoryModel>> response) {
                            List<ResultHistoryModel> result=response.body();
                        HistoryAdapter historyAdapter=new HistoryAdapter(getActivity(),result);
                        lvHistory.setAdapter(historyAdapter);
                        btnCheck.setClickable(true);
                    }

                    @Override
                    public void onFailure(Call<List<ResultHistoryModel>> call, Throwable t) {

                    }
                });
            }
        });

    }
    private void setDatePicker(DatePickerDialog.OnDateSetListener mOnDateSetListener){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                getActivity(),
                android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth,
                mOnDateSetListener,
                year,month,day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(170,35,35,35)));
        datePickerDialog.show();
    }
    private boolean checkEditTextEmpty(EditText ed,String title){
        if(ed.getText().toString().isEmpty()){
            Toast.makeText(getContext(),title,Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    private boolean checkTextViewEmpty(TextView ed,String title){
        if(ed.getText().toString().isEmpty()){
            Toast.makeText(getContext(),title,Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
