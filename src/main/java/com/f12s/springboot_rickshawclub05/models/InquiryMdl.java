package com.f12s.springboot_rickshawclub05.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="inquiry")
public class InquiryMdl {

    // (1a) min required fields all mdl/tbl
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)  // This will not allow the createdAt column to be updated after creation
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // (1b) mdl/tbl specific fields
    private String email;

    private String nameFirst;

    private String nameLast;

    private String ethereumWalletAddy;

    //

    // (2a) joins to put other tables' cols on this mdl

    // (2b) joins to put "inquiry_id" col on other tables


    // (3) instantiate the model:
    public InquiryMdl() {}

    // (4) add methods to populate maintain createdAt/UpdatedAt
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    // (5) required code to support api calls
    public InquiryMdl(String email, String nameFirst,String nameLast, String ethereumWalletAddy) {
        this.email = email;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.ethereumWalletAddy = ethereumWalletAddy;
    }

    // (6) getters/setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getEthereumWalletAddy() {
        return ethereumWalletAddy;
    }

    public void setEthereumWalletAddy(String ethereumWalletAddy) {
        this.ethereumWalletAddy = ethereumWalletAddy;
    }
} // end mdl
