/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoangminhk4b
 */
@Entity
@Table(name = "history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h")
    , @NamedQuery(name = "History.findById", query = "SELECT h FROM History h WHERE h.id = :id")
    , @NamedQuery(name = "History.findByMaDT", query = "SELECT h FROM History h WHERE h.maDT = :maDT")
    , @NamedQuery(name = "History.findByMaKH", query = "SELECT h FROM History h WHERE h.maKH = :maKH")
    , @NamedQuery(name = "History.findByUsername", query = "SELECT h FROM History h WHERE h.maKH = :maKH OR h.maDT= :maKH")
    , @NamedQuery(name = "History.findBySoTien", query = "SELECT h FROM History h WHERE h.soTien = :soTien")
    , @NamedQuery(name = "History.findByNgayGD", query = "SELECT h FROM History h WHERE h.ngayGD = :ngayGD")
    , @NamedQuery(name = "History.findByPhiGD", query = "SELECT h FROM History h WHERE h.phiGD = :phiGD")})
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "maDT")
    private String maDT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "maKH")
    private String maKH;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soTien")
    private int soTien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "ngayGD")
    private String ngayGD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phiGD")
    private int phiGD;

    public History() {
    }

    public History(Integer id) {
        this.id = id;
    }

    public History(String maDT, String maKH, int soTien, String ngayGD, int phiGD) {
        this.maDT = maDT;
        this.maKH = maKH;
        this.soTien = soTien;
        this.ngayGD = ngayGD;
        this.phiGD = phiGD;
    }
    

    public History(Integer id, String maDT, String maKH, int soTien, String ngayGD, int phiGD) {
        this.id = id;
        this.maDT = maDT;
        this.maKH = maKH;
        this.soTien = soTien;
        this.ngayGD = ngayGD;
        this.phiGD = phiGD;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public String getNgayGD() {
        return ngayGD;
    }

    public void setNgayGD(String ngayGD) {
        this.ngayGD = ngayGD;
    }

    public int getPhiGD() {
        return phiGD;
    }

    public void setPhiGD(int phiGD) {
        this.phiGD = phiGD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utils.History[ id=" + id + " ]";
    }
    
}
