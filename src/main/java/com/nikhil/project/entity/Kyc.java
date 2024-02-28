package com.nikhil.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name="kyc")
public class Kyc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "aadhar_number")
    private int aadharNumber;

    @OneToOne(mappedBy = "kyc")
    private BankDetails bankDetails;

    public Kyc() {
    }

    public Kyc(User user, int aadharNumber) {
        this.user = user;
        this.aadharNumber = aadharNumber;
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

    public int getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(int aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    @Override
    public String toString() {
        return "Kyc{" +
                "id=" + id +
                ", user=" + user +
                ", aadharNumber='" + aadharNumber + '\'' +
                '}';
    }
}
