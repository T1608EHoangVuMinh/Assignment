package com.example.hoangminhk4b.dwsj_banking.models;

public class FormService {
    private String maDT;
    private String mkDT;
    private String maKH;
    private String maTKKH;
    private int maPin;
    private int soTien;

    public FormService(String maDT, String mkDT, String maKH, String maTKKH, int maPin, int soTien) {
        this.maDT = maDT;
        this.mkDT = mkDT;
        this.maKH = maKH;
        this.maTKKH = maTKKH;
        this.maPin = maPin;
        this.soTien = soTien;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getMkDT() {
        return mkDT;
    }

    public void setMkDT(String mkDT) {
        this.mkDT = mkDT;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaTKKH() {
        return maTKKH;
    }

    public void setMaTKKH(String maTKKH) {
        this.maTKKH = maTKKH;
    }

    public int getMaPin() {
        return maPin;
    }

    public void setMaPin(int maPin) {
        this.maPin = maPin;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }
}
