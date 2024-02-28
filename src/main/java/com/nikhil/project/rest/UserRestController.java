package com.nikhil.project.rest;

import com.nikhil.project.entity.BankDetails;
import com.nikhil.project.entity.Kyc;
import com.nikhil.project.entity.User;
import com.nikhil.project.entity.UserAddress;
import com.nikhil.project.request.LoginRequest;
import com.nikhil.project.request.OtpRequest;
import com.nikhil.project.request.SignUpRequest;
import com.nikhil.project.response.SignupMessage;
import com.nikhil.project.response.VerificationMessage;
import com.nikhil.project.service.UserService;
//import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private static final Logger logger = LogManager.getLogger(UserRestController.class);
    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService){
        userService=theUserService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpRequest theSignUpRequest) {

        User theUser=theSignUpRequest.getUser();
        String num=theUser.getMobileNo();
        User user=userService.findByNo(num);
        logger.debug("Signup request received with user: {}", theUser);
        UserAddress theUserAddress=theSignUpRequest.getUserAddress();
        Kyc theKyc=theSignUpRequest.getKyc();
        BankDetails theBankDetails=theSignUpRequest.getBankDetails();
        if(user==null){
            SignupMessage signupMessage = userService.signUp(theUser, theUserAddress, theKyc, theBankDetails);
            return ResponseEntity.ok(signupMessage);
        }
        else{
            String signupMessage="Already a user existed";
            return ResponseEntity.ok(signupMessage);
        }
//        logger.info("Signup successful, user created");
    }

    @PostMapping("/login")
    public List<User> getUser(@RequestBody LoginRequest theLoginRequest) {
        String fullName= theLoginRequest.getFullName();
        String password= theLoginRequest.getPassword();
        List<User> dbUsers = userService.logIn(fullName,password);
        return dbUsers;
    }

    @PatchMapping("/verify")
    public ResponseEntity<?> verifyOtp(@RequestBody OtpRequest theOtpRequest){
        String fullName=theOtpRequest.getFullName();
        User user=userService.findByName(fullName);
        int otp=theOtpRequest.getOtp();
        if(otp==1234){
//            user.setVerify(true);
            VerificationMessage verificationMessage=userService.updateUser(user);
            return ResponseEntity.ok(verificationMessage);
        }
        else{
            return ResponseEntity.ok("Verification failed");
        }
    }

}
