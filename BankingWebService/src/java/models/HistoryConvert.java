/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hoangminhk4b
 */
public class HistoryConvert {
    String username;
    String maGD;
    String soTien;
    int phiGD;
    String ngayGD;

    public HistoryConvert() {
    }

    public HistoryConvert(String username, String maGD, String soTien, int phiGD, String ngayGD) {
        this.username = username;
        this.maGD = maGD;
        this.soTien = soTien;
        this.phiGD = phiGD;
        this.ngayGD = ngayGD;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMaGD() {
        return maGD;
    }

    public void setMaGD(String maGD) {
        this.maGD = maGD;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }

    public int getPhiGD() {
        return phiGD;
    }

    public void setPhiGD(int phiGD) {
        this.phiGD = phiGD;
    }

    public String getNgayGD() {
        return ngayGD;
    }

    public void setNgayGD(String ngayGD) {
        this.ngayGD = ngayGD;
    }
}
