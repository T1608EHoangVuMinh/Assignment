package com.example.hoangminhk4b.dwsj_banking.dataSource;

import com.example.hoangminhk4b.dwsj_banking.models.ResultHistoryModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIHistory {
    String URL_BASE="http://192.168.1.24:8181/BankingWebService/banking/v1/history/";

    @POST("getHistory")
    Call<List<ResultHistoryModel>> getHistory(@Body Map<String,Object> body);
}
