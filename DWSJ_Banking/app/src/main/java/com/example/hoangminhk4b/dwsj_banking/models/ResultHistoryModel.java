package com.example.hoangminhk4b.dwsj_banking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultHistoryModel {

    @SerializedName("ngayGD")
    @Expose
    private String ngayGD;
    @SerializedName("phiGD")
    @Expose
    private Integer phiGD;
    @SerializedName("soTien")
    @Expose
    private String soTien;
    @SerializedName("username")
    @Expose
    private String username;

    public String getNgayGD() {
        return ngayGD;
    }

    public void setNgayGD(String ngayGD) {
        this.ngayGD = ngayGD;
    }

    public Integer getPhiGD() {
        return phiGD;
    }

    public void setPhiGD(Integer phiGD) {
        this.phiGD = phiGD;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

