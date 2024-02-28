package com.nikhil.project.request;

import com.nikhil.project.entity.BankDetails;
import com.nikhil.project.entity.Kyc;
import com.nikhil.project.entity.User;
import com.nikhil.project.entity.UserAddress;

public class SignUpRequest {
    User user;
    UserAddress userAddress;
    Kyc kyc;
    BankDetails bankDetails;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public Kyc getKyc() {
        return kyc;
    }

    public void setKyc(Kyc kyc) {
        this.kyc = kyc;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }
}
