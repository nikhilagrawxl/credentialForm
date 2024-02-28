package com.nikhil.project.service;

import com.nikhil.project.entity.BankDetails;
import com.nikhil.project.entity.Kyc;
import com.nikhil.project.entity.User;
import com.nikhil.project.entity.UserAddress;
import com.nikhil.project.response.SignupMessage;
import com.nikhil.project.response.VerificationMessage;

import java.util.List;

public interface UserService {
    SignupMessage signUp(User theUser, UserAddress theUserAddress, Kyc theKyc, BankDetails theBankDetails);

    List<User> findAll();

    User findById(int theId);

    User findByName(String fullName);

    List<User> logIn(String fullName, String password);

    VerificationMessage updateUser(User theUser);

    User findByNo(String num);
}
