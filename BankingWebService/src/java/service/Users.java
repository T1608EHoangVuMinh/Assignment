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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.getCardNumber", query = "SELECT u FROM Users u WHERE u.username = :username AND u.password=:password")
    , @NamedQuery(name = "Users.checkCardNumber", query = "SELECT u FROM Users u WHERE u.cardnumber = :cardnumber AND u.cardpin = :cardpin")
    , @NamedQuery(name = "Users.check", query = "SELECT u FROM Users u WHERE u.username = :username OR u.cardnumber= :username")
    , @NamedQuery(name = "Users.findByCardnumber", query = "SELECT u FROM Users u WHERE u.cardnumber = :cardnumber")
    , @NamedQuery(name = "Users.findByCardpin", query = "SELECT u FROM Users u WHERE u.cardpin = :cardpin")
    , @NamedQuery(name = "Users.findByTotalmoney", query = "SELECT u FROM Users u WHERE u.totalmoney = :totalmoney")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cardnumber")
    private String cardnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cardpin")
    private int cardpin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalmoney")
    private int totalmoney;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String username, String password, String cardnumber, int cardpin, int totalmoney) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cardnumber = cardnumber;
        this.cardpin = cardpin;
        this.totalmoney = totalmoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getCardpin() {
        return cardpin;
    }

    public void setCardpin(int cardpin) {
        this.cardpin = cardpin;
    }

    public int getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(int totalmoney) {
        this.totalmoney = totalmoney;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.Users[ id=" + id + " ]";
    }
    
}
