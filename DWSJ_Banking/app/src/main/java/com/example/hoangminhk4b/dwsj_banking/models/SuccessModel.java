package com.example.hoangminhk4b.dwsj_banking.models;

public class SuccessModel {
    private String tvMaDT;
    private String tvMaKH;
    private String tvMaTKKH;
    private String tvMoney;
    private String tvPhi;

    public SuccessModel(String tvMaDT, String tvMaKH, String tvMaTKKH, String tvMoney, String tvPhi) {
        this.tvMaDT = tvMaDT;
        this.tvMaKH = tvMaKH;
        this.tvMaTKKH = tvMaTKKH;
        this.tvMoney = tvMoney;
        this.tvPhi = tvPhi;
    }

    public String getTvMaDT() {
        return tvMaDT;
    }

    public void setTvMaDT(String tvMaDT) {
        this.tvMaDT = tvMaDT;
    }

    public String getTvMaKH() {
        return tvMaKH;
    }

    public void setTvMaKH(String tvMaKH) {
        this.tvMaKH = tvMaKH;
    }

    public String getTvMaTKKH() {
        return tvMaTKKH;
    }

    public void setTvMaTKKH(String tvMaTKKH) {
        this.tvMaTKKH = tvMaTKKH;
    }

    public String getTvMoney() {
        return tvMoney;
    }

    public void setTvMoney(String tvMoney) {
        this.tvMoney = tvMoney;
    }

    public String getTvPhi() {
        return tvPhi;
    }

    public void setTvPhi(String tvPhi) {
        this.tvPhi = tvPhi;
    }

}
