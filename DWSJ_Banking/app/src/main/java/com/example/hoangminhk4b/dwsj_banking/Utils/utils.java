package com.example.hoangminhk4b.dwsj_banking.Utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class utils {
    public static int phiGD(String tienGD) {
        int tienGDINT=Integer.parseInt(tienGD);
        if (tienGDINT <= 100000) {
            return 10000;
        } else if (tienGDINT > 100000 && tienGDINT <= 500000) {
            return (int) (tienGDINT * 0.02);
        } else if (tienGDINT > 500000 && tienGDINT <= 1000000) {
            return (int) (tienGDINT * 0.015);
        } else if (tienGDINT > 1000000 && tienGDINT <= 5000000) {
            return (int) (tienGDINT * 0.01);
        } else {
            return (int) (tienGDINT * 0.005);
        }
    }
    public static void setDatePicker(DatePickerDialog.OnDateSetListener mOnDateSetListener,Activity activity){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                activity,
                android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth,
                mOnDateSetListener,
                year,month,day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(170,35,35,35)));
        datePickerDialog.show();
    }
    public static boolean checkEditTextEmpty(EditText ed,String title,Activity activity){
        if(ed.getText().toString().isEmpty()){
            Toast.makeText(activity,title,Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    public static boolean checkTextViewEmpty(TextView ed, String title,Activity activity){
        if(ed.getText().toString().isEmpty()){
            Toast.makeText(activity,title,Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    public static int convertDateToTimestamp(String date){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d=sdf.parse(date);
            return (int)Math.floor(d.getTime()/1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static String convertTimestampToDate(int timestamp){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp*1000L);
        Date d = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return sdf.format(d);
    }
}
