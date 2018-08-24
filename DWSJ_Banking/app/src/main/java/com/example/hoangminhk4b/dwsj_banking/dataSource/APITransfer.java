package com.example.hoangminhk4b.dwsj_banking.dataSource;

import com.example.hoangminhk4b.dwsj_banking.models.FormService;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APITransfer {
    String URL_BASE="http://192.168.1.24:8181/BankingWebService/banking/v1/users/";

    @POST("sendFormToService")
    Call<String> sendFormToService(@Body FormService formService);
}
