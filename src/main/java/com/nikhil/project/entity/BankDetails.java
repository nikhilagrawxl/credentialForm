package com.nikhil.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name="bank_details")
public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "account_number")
    private int accountNumber;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @OneToOne
    @JoinColumn(name = "aadhar_number", referencedColumnName = "aadhar_number")
    private Kyc kyc;

    @Column(name = "aadhar_number", insertable = false, updatable = false)
    private int aadharNumber;


    public BankDetails() {
    }

    public BankDetails(User user, int accountNumber, String ifscCode, int aadharNumber, Kyc kyc) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.aadharNumber = aadharNumber;
        this.kyc = kyc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public int getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(int aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public Kyc getKyc() {
        return kyc;
    }

    public void setKyc(Kyc kyc) {
        this.kyc = kyc;
    }

    @Override
    public String toString() {
        return "BankDetails{" +
                "id=" + id +
                ", user=" + user +
                ", accountNumber=" + accountNumber +
                ", ifscCode='" + ifscCode + '\'' +
                ", aadharNumber=" + aadharNumber +
                ", kyc=" + kyc +
                '}';
    }
}
